import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.opencv.core.Core;
import static org.opencv.core.CvType.CV_32FC1;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt4;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C;
import static org.opencv.imgproc.Imgproc.CHAIN_APPROX_SIMPLE;
import static org.opencv.imgproc.Imgproc.RETR_EXTERNAL;
import static org.opencv.imgproc.Imgproc.THRESH_BINARY_INV;

//XML - write.
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class genData {


    private static final int 
            MIN_CONTOUR_AREA = 100,
            RESIZED_IMAGE_WIDTH = 20,
            RESIZED_IMAGE_HEIGHT = 30;

    public static void main(String[] args) throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
        Scanner keyboard = new Scanner(System.in);

        Mat imgTrainingNumbers;
        Mat imgGrayscale = new Mat();
        Mat imgBlurred = new Mat();
        Mat imgThresh = new Mat();
        Mat imgThreshCopy = new Mat();

        ArrayList<MatOfPoint> ptContours = new ArrayList<MatOfPoint>();
        MatOfInt4 v4iHierarchy = new MatOfInt4();

        List<Integer> matClassificationInts = new ArrayList<Integer>();

        Mat matTrainingImagesAsFlattenedFloats = new Mat();

        int[] intValidChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'E', 'H',
        'K', 'M', 'O', 'P', 'T',
        'X', 'Y'};
        Arrays.sort(intValidChars);

        imgTrainingNumbers = Imgcodecs.imread("01.png");

        if (imgTrainingNumbers.empty()) {
            System.out.println("Error: file is not found");
            return;
        }

        Imgproc.cvtColor(imgTrainingNumbers, imgGrayscale, Imgproc.COLOR_BGR2GRAY);
        Imgproc.GaussianBlur(imgGrayscale, imgBlurred, new Size(5, 5), 0);
        Imgproc.adaptiveThreshold(imgBlurred, imgThresh, 255, ADAPTIVE_THRESH_GAUSSIAN_C, THRESH_BINARY_INV, 11, 2);

        Imshow im = new Imshow("imgThresh");
        im.showImage(imgThresh);
        imgThreshCopy = imgThresh.clone();

        Imgproc.findContours(imgThreshCopy, ptContours, v4iHierarchy, RETR_EXTERNAL, CHAIN_APPROX_SIMPLE);


        for (int i = 0; i < ptContours.size(); i++) {
            if (Imgproc.contourArea(ptContours.get(i)) > MIN_CONTOUR_AREA) {
                Rect boundingRect = Imgproc.boundingRect(ptContours.get(i));
                Imgproc.rectangle(imgTrainingNumbers, boundingRect.tl(), boundingRect.br(), new Scalar(0, 0, 255), 2);
                Mat matROI = imgThresh.submat(boundingRect.y, boundingRect.y + boundingRect.height, boundingRect.x, boundingRect.x + boundingRect.width);
                Mat matROIResized = new Mat();
                Imgproc.resize(matROI, matROIResized, new Size(RESIZED_IMAGE_WIDTH, RESIZED_IMAGE_HEIGHT));
                im.showImage(matROI);
                im.showImage(matROIResized);
                im.showImage(imgTrainingNumbers);
                String input = keyboard.nextLine();
                int intChar = (int)input.charAt(0);
                if (Arrays.binarySearch(intValidChars, intChar) >=0) {
                    matClassificationInts.add(new Integer(intChar));
                    Mat matImageFloat = new Mat();
                    matROIResized.convertTo(matImageFloat, CV_32FC1);
                    Mat matImageFlattenedFloat = matImageFloat.reshape(1, 1);
                    matTrainingImagesAsFlattenedFloats.push_back(matImageFlattenedFloat);
                }
            }
        }

        String dataImages = "";
        for (Integer i : matClassificationInts) {
            dataImages += i + " ";
        }

        String dataClassifications = "";
        for (int i = 0; i < matTrainingImagesAsFlattenedFloats.rows(); i++) {
            for (int j = 0; j < matTrainingImagesAsFlattenedFloats.cols(); j++) {
                double[] temp = matTrainingImagesAsFlattenedFloats.get(i, j);
                dataClassifications += temp[0] + " ";
            }
            dataClassifications += "\n";
        }

        String rowsImages = String.valueOf(matClassificationInts.size());
        String colsImages = "1";
        String rowsClassifications = String.valueOf(matTrainingImagesAsFlattenedFloats.rows());
        String colsClassifications = String.valueOf(matTrainingImagesAsFlattenedFloats.cols());

        DocumentBuilderFactory icFactory_images = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder_images;
        try {
            icBuilder_images = icFactory_images.newDocumentBuilder();
            Document doc = icBuilder_images.newDocument();
            Element mainRootElement = doc.createElement("opencv_storage");
            doc.appendChild(mainRootElement);
            mainRootElement.appendChild(getMatXML(doc, "classifications", "opencv-matrix", rowsImages, colsImages, "i", dataImages));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(doc);
            String filename = "classifications.xml";
            File file = new File(filename);
            StreamResult console = new StreamResult(file); //(System.out)
            transformer.transform(source, console);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DocumentBuilderFactory icFactory_classifications = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder_classifications;
        try {
            icBuilder_classifications = icFactory_classifications.newDocumentBuilder();
            Document doc = icBuilder_classifications.newDocument();
            Element mainRootElement = doc.createElement("opencv_storage");
            doc.appendChild(mainRootElement);
            mainRootElement.appendChild(getMatXML(doc, "images", "opencv-matrix", rowsClassifications, colsClassifications, "f", dataClassifications));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(doc);
            String filename = "images.xml";
            File file = new File(filename);
            StreamResult console = new StreamResult(file); //(System.out)
            transformer.transform(source, console);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finished.");
        System.exit(0);
    }   

    private static Node getMatXML(Document doc, String option_id, String type_id, String rows, String cols, String dt, String data) {
        Element elem = doc.createElement(option_id);
        elem.setAttribute("type_id", type_id);
        elem.appendChild(getMatXMLElement(doc,"rows", rows));
        elem.appendChild(getMatXMLElement(doc, "cols", cols));
        elem.appendChild(getMatXMLElement(doc, "dt", dt));
        elem.appendChild(getMatXMLElement(doc, "data", data));
        return elem;
    }

    private static Node getMatXMLElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import static org.opencv.highgui.Highgui.imwrite;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetector {
    private static Mat cropImage;

public static void main(String[] args)throws Exception {
    int x = 0,y = 0,height = 0,width = 0;

    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");

//CascadeClassifier faceDetector = new       CascadeClassifier(FaceDetector.class.getResource("haarcascade_frontalface_alt.xm    l").getPath());
    CascadeClassifier faceDetector = new CascadeClassifier(Snapshot.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
Mat image = Highgui.imread("C:\\image.jpg");
faceDetector.detectMultiScale(image, face_Detections);
System.out.println(String.format("Detected %s faces",  face_Detections.toArray().length));
Rect rect_Crop=null;
for (Rect rect : face_Detections.toArray()) {
    Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
            new Scalar(0, 255, 0));
    rectCrop = new Rect(rect.x, rect.y, rect.width, rect.height);
}



 Mat image_roi = new Mat(image,rectCrop);
  Highgui.imwrite("C:\\cropimage_912.jpg",image_roi);



}}
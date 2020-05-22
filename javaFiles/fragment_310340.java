import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import org.opencv.photo.Photo;

public class Dnoise {

    public static void doDnoise()
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat rgb = Highgui.imread("ybD8q.jpg");

        Mat gray = new Mat(rgb.size(), CvType.CV_8U);
        Imgproc.cvtColor(rgb, gray, Imgproc.COLOR_BGR2GRAY);
        Mat mask = new Mat(rgb.size(), CvType.CV_8U);
        Imgproc.threshold(gray, mask, 70, 255, Imgproc.THRESH_BINARY_INV);
        Mat dn = new Mat(rgb.size(), CvType.CV_8UC3);
        Photo.inpaint(rgb, mask, dn, 20, Photo.INPAINT_TELEA);
    }

}
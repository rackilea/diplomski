import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core;

public class test
{
    public static void main(String[] args)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat image = Imgcodecs.imread("test.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        if ((image == null) || image.empty()) {
            System.out.println("Failed to load input image.");
            System.exit(-1);
        }

        Mat image_hsv = new Mat();
        Imgproc.cvtColor(image, image_hsv, Imgproc.COLOR_BGR2HSV);

        Mat mask1 = new Mat();
        Mat mask2 = new Mat();
        Core.inRange(image_hsv, new Scalar(0, 70, 50), new Scalar(10, 255, 255), mask1);
        Core.inRange(image_hsv, new Scalar(170, 70, 50), new Scalar(180, 255, 255), mask2);

        Mat mask_combined = new Mat();
        Core.bitwise_or(mask1, mask2, mask_combined);

        Mat image_masked = new Mat();
        Core.bitwise_and(image, image, image_masked, mask_combined);

        Imgcodecs.imwrite("test-mask.jpg", mask_combined);        
        Imgcodecs.imwrite("test-masked.jpg", image_masked);

        System.out.println("Done!");
    }
}
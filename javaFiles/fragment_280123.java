import java.awt.Color;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.highgui.Highgui;

public class OpenCVThing
{
    public static void main(String[] args)
    {
        String opencvpath = System.getProperty("user.dir") + "\\lib\\";
        System.load(opencvpath + Core.NATIVE_LIBRARY_NAME + ".dll");
        // Get the whole rect into smallImg
        Mat firstImage = Highgui.imread("capture.png");
        System.out.println("total pxels:" + firstImage.total());
        // We are getting a column 30 high and 30 wide
        int width = 30;
        int height = 30;
        Rect roi = new Rect(120, 160, width, height);
        Mat smallImg = new Mat(firstImage, roi);
        int channels = smallImg.channels();
        System.out.println("small pixels:" + smallImg.total());
        System.out.println("channels:" + smallImg.channels());
        int totalBytes = (int)(smallImg.total() * smallImg.channels());
        byte buff[] = new byte[totalBytes];
        smallImg.get(0, 0, buff);

        // assuming it's of CV_8UC3 == BGR, 3 byte/pixel
        // Effectively assuming channels = 3
        for (int i=0; i< height; i++)
        {
            // stride is the number of bytes in a row of smallImg
            int stride = channels * width;
            for (int j=0; j<stride; j+=channels)
            {
                int b = buff[(i * stride) + j];
                int g = buff[(i * stride) + j + 1]; 
                int r = buff[(i * stride) + j + 2];
                float[] hsv = new float[3];
                Color.RGBtoHSB(r,g,b,hsv);
                // Do something with the hsv.
                System.out.println("hsv: " + hsv[0]);
            }
        }
    }
}
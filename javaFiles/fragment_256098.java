package main;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;


import helper.ImageProcHelper;


public class Main {


    public static void main(String[] args) throws Exception {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File file = new File("C:\\Users\\Enrico Gründig\\Desktop\\Samples\\pic4.png");

        Mat mat = new Mat(CvType.CV_8UC4);
        Mat procMat = new Mat();
        Mat hierarchy = new Mat();
        Scalar color = new Scalar(0,0,255);
        List<MatOfPoint> contours = new ArrayList<>();

        try {
            BufferedImage picture = ImageIO.read(file);
            BufferedImage image = new BufferedImage(picture.getWidth(), picture.getHeight(), 5);
            image.getGraphics().drawImage(picture, 0, 0, null);

            System.out.println(image.getType());
            mat = ImageProcHelper.ImageToMat(image);

            Imgproc.cvtColor(mat, procMat, Imgproc.COLOR_RGBA2GRAY);
            Imgproc.blur(procMat, procMat, new Size(3,3));
            Imgproc.Canny(procMat, procMat, 127, 255);

            //Konturen finden           
            Imgproc.findContours(procMat, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);

            MatOfPoint2f[] contoursPoly = new MatOfPoint2f[contours.size()];
            Rect[] boundRect = new Rect[contours.size()];           


            for(int i = 0; i < contours.size(); i++) {
                contoursPoly[i] = new MatOfPoint2f();
                Imgproc.approxPolyDP(new MatOfPoint2f(contours.get(i).toArray()), contoursPoly[i], 0.1,  true);
                boundRect[i] = Imgproc.boundingRect(new MatOfPoint(contours.get(i).toArray()));  
            }


            for (int i = 0; i < contours.size(); i++) {
                if (contoursPoly[i].size()>15){
                    Imgproc.rectangle(mat, boundRect[i].tl(), boundRect[i].br(), color, 1);
                }
            }

            image = ImageProcHelper.MatToImage(mat);
            ImageIO.write((RenderedImage)image, "png", new File ("C:\\Users\\Enrico Gründig\\Desktop\\Samples\\output.png"));


        } catch (IOException e) {
            System.out.println("Error");
        }   
    }
}
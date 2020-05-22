import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;


public class Robot extends JPanel implements Runnable {

    static BufferedImage bufImagew = null;
    public Robot() {

        JFrame f=new JFrame();
        f.setVisible(true);
        f.add(this);
        f.setSize(new Dimension(640,500));

    }

    @Override
    public void run() {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera = new VideoCapture(0);
        // 1 for next camera
        int i = 0;
        try {

            Mat frame = new Mat();
            while (true) {
                    camera.read(frame);
                    Mat image_tmp = frame;

                    MatOfByte matOfByte = new MatOfByte();
                    BufferedImage bufImage = null;

                    if(image_tmp!=null)
                    Highgui.imencode(".jpg", image_tmp, matOfByte); 


                    byte[] byteArray = matOfByte.toArray();
                    try {

                        InputStream in = new ByteArrayInputStream(byteArray);
                        bufImage = ImageIO.read(in);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    bufImagew=bufImage;
                    this.repaint();
                    if(i==5)
                        i=0;
                } 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        DetectFaceDemo d=new DetectFaceDemo();
        try {

        super.paintComponent(g);
        g.drawImage(bufImagew,0,0,null);

        }
        catch(Exception e){}
    }

    public static void main(String[] args) {
        Robot gs = new Robot();
        Thread th = new Thread(gs);
        th.start();
    }
}
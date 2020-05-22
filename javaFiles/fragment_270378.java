import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.*;

public class TestImageDraw {

    public static JFrame frame;
    BufferedImage img;
    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public TestImageDraw() {
    }

    public static void main(String[] a){

        TestImageDraw t=new TestImageDraw();

        frame = new JFrame("WINDOW");
        frame.setVisible(true);

        t.start();
        frame.add(new JLabel(new ImageIcon(t.getImage())));

        frame.pack();
//      frame.setSize(WIDTH, HEIGHT);
        // Better to DISPOSE than EXIT
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Image getImage() {
        return img;
    }

    public void start(){

        img = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
        int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
        boolean running=true;
        while(running){
            BufferStrategy bs=frame.getBufferStrategy();
            if(bs==null){
                frame.createBufferStrategy(4);
                return;
            }
            for (int i = 0; i < WIDTH * HEIGHT; i++)
                pixels[i] = 0;

            Graphics g= bs.getDrawGraphics();
            g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
            g.dispose();
            bs.show();

        }
    }
}
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;

public class BigScrollImage {

    BigScrollImage() {
        final int x = 5000;
        final int y = 5000;
        final BufferedImage bi = new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
        Graphics2D g1 = bi.createGraphics();

        g1.setColor(Color.BLACK);
        g1.fillRect(0, 0, x, y);

        g1.dispose();

        final JLabel label = new JLabel(new ImageIcon(bi));

        ActionListener listener = new ActionListener() {
            Random rand = new Random();
            @Override
            public void actionPerformed(ActionEvent ae) {
                Graphics2D g2 = bi.createGraphics();
                int x1 = rand.nextInt(x);
                int x2 = rand.nextInt(x);
                int y1 = rand.nextInt(y);
                int y2 = rand.nextInt(y);
                int r = rand.nextInt(255);
                int g = rand.nextInt(255);
                int b = rand.nextInt(255);
                g2.setColor(new Color(r,g,b));
                g2.drawLine(x1,y1,x2,y2);

                g2.dispose();
                label.repaint();
            }
        };

        Timer t = new Timer(5,listener);

        JScrollPane scroll = new JScrollPane(label);
        JFrame f = new JFrame("Big Scroll");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f.add(scroll);
        f.pack();
        f.setSize(800, 600);

        f.setLocationByPlatform(true);
        f.setVisible(true);
        t.start();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new BigScrollImage();
            }
        });
    }
}
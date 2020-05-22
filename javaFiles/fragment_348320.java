package CaRII;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class P{

    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                P p = new P();
                p.go();
            }
        });
    }

    public void go(){
        try {
            JFrame frame = new JFrame("CaRRI: Call and Response Intelligent Improviser");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            PBackground mainPanel = new PBackground();

            frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

            //frame.setSize(800,500);
            frame.pack();
            frame.setMinimumSize(frame.getSize());
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class PBackground extends JPanel{

    public BufferedImage backgroundImage;


    public PBackground() throws Exception {
        URL url = new URL("http://desmond.imageshack.us/Himg189/" + 
            "scaled.php?server=189&filename=cariibackground.jpg&res=medium");
        // You might form that URL using something like..
        //URL url = this.getClass().getResource("/CaRIIBackGround.jpg");

        backgroundImage = ImageIO.read(url);
        Dimension d = new Dimension(
            backgroundImage.getWidth(),
            backgroundImage.getHeight());
        setPreferredSize(d);
    }

    /*  What was this supposed to achieve?
    public PBackground(LayoutManager layout){
        backgroundImage = Toolkit.getDefaultToolkit().createImage("CaRIIBackGround.jpg");
    }
    */

    // Don't override paint() in a Swing panel!
    //public void paint(Graphics g){
    @Override
    public void paintComponent(Graphics g) {
        // USE the ImageObserver!
        //g.drawImage(backgroundImage,0,0,null);
        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),this);
    }
}
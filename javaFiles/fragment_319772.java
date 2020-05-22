import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//No need to extend your class with JFrame
public class Board {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //Instantiate Panel class.
                Panel panel = new Panel();
                //Set instance of Panel class as a content pane for your JFrame
                frame.setContentPane(panel);
                //Avoid calling setSize. Call pack instead
                frame.pack();
                //If you want to position your frame on center of screen, no need
                //for fancy calculations. This is how you can do it.
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

    /*Image will be displayed on JPanel*/
    private static class Panel extends JPanel {
        BufferedImage image;

        public Panel() {
            try {
                //String you are passing in "new File()" is a path to your image
                image = ImageIO.read(new File("path-to-your-image"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*Override this method to display graphics on JPanel.
        * Do not override paint method!*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image,0,0,this);

        }

        /*Override getPreferredSize method so it returns dimensions of your image.
        * Size of your container (Panel) will be equal to size of that image*/
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(image.getWidth(),image.getHeight());
        }
    }
}
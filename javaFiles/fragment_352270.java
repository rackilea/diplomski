import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestGif {

    public TestGif() {
        JFrame frame = new JFrame();
        frame.add(new GifPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class GifPanel extends JPanel {
        Image image;
        {
            try {
                image = new ImageIcon(new URL("http://i.stack.imgur.com/lKfdp.gif")).getImage();
            } catch (MalformedURLException ex) {
                Logger.getLogger(TestGif.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
        @Override
        public Dimension getPreferredSize() {
            return image == null ? new Dimension(200, 200) 
                    : new Dimension(image.getWidth(this), image.getHeight(this));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestGif();
            }
        });
    }
}
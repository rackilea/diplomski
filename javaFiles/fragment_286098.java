import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JBackGroundImageClass extends JFrame {

    private Image img;
    public JBackGroundImageClass() {
        this.setLayout(new BorderLayout());
        try {
            img = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        this.add(new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(img.getWidth(null), img.getHeight(null));
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JBackGroundImageClass().setVisible(true);
            }
        });
    }
}
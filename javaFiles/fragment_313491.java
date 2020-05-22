import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class TestTextField {

    public static void main(String[] args) {
        new TestTextField();
    }

    public TestTextField() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextField field = new JTextField(20);
                try {
                    BufferedImage img = ImageIO.read(getClass().getResource("/FieldBorder.png"));
                    field.setBorder(new ImageBorder(img, 8, 6));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(field);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ImageBorder implements Border {

        private BufferedImage img;
        private int bottomMargin;
        private int leftMargin;

        public ImageBorder(BufferedImage img, int leftMargin, int bottomMargin) {
            this.img = img;
            this.bottomMargin = bottomMargin;
            this.leftMargin = leftMargin;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawImage(img, x, y + height - img.getHeight(), c);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(0, leftMargin, bottomMargin, 0);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

    }

}
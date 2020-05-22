import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.Document;

public class TextFieldBackground {

    public static void main(String[] args) {
        new TextFieldBackground();
    }

    public TextFieldBackground() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                TextFieldWithBackground field = new TextFieldWithBackground(40);
                try {
                    field.setBackgroundImage(ImageIO.read(getClass().getResource("/clouds.jpg")));
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

    public class TextFieldWithBackground extends JTextField {

        private BufferedImage bg;

        public TextFieldWithBackground() {
        }

        public TextFieldWithBackground(String text) {
            super(text);
        }

        public TextFieldWithBackground(int columns) {
            super(columns);
        }

        public TextFieldWithBackground(String text, int columns) {
            super(text, columns);
        }

        public TextFieldWithBackground(Document doc, String text, int columns) {
            super(doc, text, columns);
        }

        public void setBackgroundImage(BufferedImage bg) {
            this.bg = bg;
            setOpaque(bg == null);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (bg != null) {
                int x = 0;
                int y = (getHeight() - bg.getHeight()) / 2;
                while (x < getWidth()) {
                    g.drawImage(bg, x, y, this);
                    x += bg.getWidth();
                }
            }
            super.paintComponent(g);
        }

    }

}
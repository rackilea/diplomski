import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class ColorPicky {

    public static void main(String[] args) {
        new ColorPicky();
    }

    public ColorPicky() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;
        private JLabel label;

        private JPanel fields;
        private JTextField red;
        private JTextField green;
        private JTextField blue;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            label = new JLabel();
            try {
                img = ImageIO.read(new File("C:\\hold\\thumbnails\\issue459.jpg"));
                label.setIcon(new ImageIcon(img));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            add(label, gbc);

            fields = new JPanel();
            fields.setBorder(new EmptyBorder(5, 5, 5, 5));
            red = new JTextField(3);
            green = new JTextField(3);
            blue = new JTextField(3);
            fields.add(red);
            fields.add(green);
            fields.add(blue);
            add(fields, gbc);

            label.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int packedInt = img.getRGB(e.getX(), e.getY());
                    Color color = new Color(packedInt, true);
                    fields.setBackground(color);
                    red.setText(Integer.toString(color.getRed()));
                    green.setText(Integer.toString(color.getGreen()));
                    blue.setText(Integer.toString(color.getBlue()));
                }
            });

        }

    }

}
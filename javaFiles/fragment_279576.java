import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Test extends JFrame {
    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MainPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MainPane extends JPanel {

        public MainPane() {
            // You could use a GridLayout, but GridBagLayout will
            // honour the preferred sizs of each component
            setLayout(new GridBagLayout());
            setBorder(new EmptyBorder(10, 10, 10, 10));
            GridBagConstraints gbc = new GridBagConstraints();
            add(new LeftPane(), gbc);
            add(new MiddleLeftPane(), gbc);
            add(new MiddlePane(), gbc);
            add(new RightPane(), gbc);
        }

    }

    public class LeftPane extends JPanel {

        public LeftPane() {
            setLayout(new GridBagLayout());

            JPanel main = new JPanel(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            for (int index = 0; index < 6; index++) {
                if (index % 2 == 0) {
                    gbc.anchor = GridBagConstraints.LINE_START;
                } else {
                    gbc.anchor = GridBagConstraints.LINE_END;
                }
                main.add(new JLabel("Label"), gbc);
            }

            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(main, gbc);

            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            add(new JButton("Button"));
        }

    }

    public class MiddleLeftPane extends JPanel {

        public MiddleLeftPane() {
            setLayout(new BorderLayout());
            BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            g2d.drawLine(0, 0, 200, 200);
            g2d.drawLine(200, 0, 0, 200);
            g2d.dispose();

            JLabel label = new JLabel(new ImageIcon(img));
            label.setBorder(new LineBorder(Color.GRAY));
            add(label);
        }

    }

    public class RightPane extends JPanel {

        public RightPane() {
            setLayout(new BorderLayout());
            BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            g2d.drawLine(0, 0, 200, 200);
            g2d.drawLine(200, 0, 0, 200);
            g2d.dispose();

            JLabel label = new JLabel(new ImageIcon(img));
            label.setBorder(new LineBorder(Color.GRAY));
            add(label);
        }

    }

    public class MiddlePane extends JPanel {

        public MiddlePane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(4, 4, 4, 4);

            add(new JButton("Button"), gbc);
            gbc.gridx++;
            add(new JButton("Button"), gbc);

            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(new JButton("Button"), gbc);

            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(new JTextArea("Text Area", 5, 10)), gbc);
        }

    }
}
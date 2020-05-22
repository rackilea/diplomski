import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            try {
                JLabel left = new JLabel(new ImageIcon(ImageIO.read(...))));
                left.setVerticalTextPosition(JLabel.BOTTOM);
                left.setHorizontalTextPosition(JLabel.CENTER);
                left.setHorizontalAlignment(JLabel.CENTER);
                left.setVerticalAlignment(JLabel.CENTER);
                left.setText(" ");
                JLabel right = new JLabel(new ImageIcon(ImageIO.read(...))));
                right.setVerticalTextPosition(JLabel.BOTTOM);
                right.setHorizontalTextPosition(JLabel.CENTER);
                right.setHorizontalAlignment(JLabel.CENTER);
                right.setVerticalAlignment(JLabel.CENTER);
                right.setText(" ");

                setLayout(new GridLayout(1, 2));

                add(left);
                add(right);

                left.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        left.setText("I'm on the left");
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        left.setText(" ");
                    }
                });
                right.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        right.setText("I'm on the right");
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        right.setText(" ");
                    }
                });
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }

}
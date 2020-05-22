import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class ButtonTest {

    public static void main(String[] args) {
        new ButtonTest();
    }

    public ButtonTest() {
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
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JButton btn = new JButton("Normal");
            add(btn, gbc);

            btn = new JButton("With border");
            btn.setBorder(new LineBorder(Color.BLACK));
            add(btn, gbc);

            btn = new JButton("borderPainted false");
            btn.setBorderPainted(false);
            btn.setBorder(new LineBorder(Color.BLACK));
            add(btn, gbc);

            btn = new JButton("contentArea false");
            btn.setContentAreaFilled(false);
            btn.setBorder(new LineBorder(Color.BLACK));
            add(btn, gbc);

            btn = new JButton("focusPained false");
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setBorder(new LineBorder(Color.BLACK));
            add(btn, gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}
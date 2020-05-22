import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RollOver {

    public static void main(String[] args) {
        new RollOver();
    }

    public RollOver() {
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

        private JLabel label;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            // I'm doing this, because I don't have blank icon of 128x128 and my
            // icons are both 128x128
            label = new JLabel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(128, 128);
                }
            };
            add(label, gbc);
            try {
                JButton btn = new JButton("Bunnies");
                btn.getModel().addChangeListener(new ChangeHandler(label, new ImageIcon(ImageIO.read(getClass().getResource("/Bunny.png")))));
                add(btn);
                btn = new JButton("Zomnies");
                btn.getModel().addChangeListener(new ChangeHandler(label, new ImageIcon(ImageIO.read(getClass().getResource("/Zombi.png")))));
                add(btn);
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

        public class ChangeHandler implements ChangeListener {

            private JLabel label;
            private Icon armedIcon;

            public ChangeHandler(JLabel label, Icon armedIcon) {
                this.armedIcon = armedIcon;
                this.label = label;
            }

            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                    label.setIcon(armedIcon);
                } else {
                    label.setIcon(null);
                }
            }

        }

    }

}
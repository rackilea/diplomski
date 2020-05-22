import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JPanel blueBox;
        private JPanel redBox;

        private JPanel top, bottom;

        public TestPane() {
            blueBox = makeBox(Color.BLUE);
            redBox = makeBox(Color.RED);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            // Filler
            add(emptyBox(), gbc);

            gbc.gridwidth = 2;
            gbc.gridheight = 2;
            gbc.fill = GridBagConstraints.BOTH;
            add(blueBox, gbc);

            gbc.gridx++;
            gbc.gridy++;
            add(redBox, gbc);

            // Filler
            gbc.gridx++;
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(emptyBox(), gbc);

            JButton flip = new JButton("Flip");
            flip.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setComponentZOrder(bottom, 0);
                    JPanel temp = top;
                    top = bottom;
                    bottom = temp;
                    repaint();
                }
            });

            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(flip, gbc);

            top = blueBox;
            bottom = redBox;
        }

        protected JPanel emptyBox() {
            JPanel box = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(50, 50);
                }
            };
            box.setOpaque(false);
            return box;
        }

        protected JPanel makeBox(Color color) {
            JPanel box = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(100, 100);
                }
            };
            box.setBackground(color);
            return box;
        }

    }

}
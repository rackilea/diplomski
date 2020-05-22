import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

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

        private JLabel label = new JLabel("---");

        public TestPane() {
            setLayout(new GridBagLayout());
            add(label);

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            am.put("left", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    label.setText("left");
                }
            });
            am.put("right", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    label.setText("right");
                }
            });
            am.put("released", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    label.setText("---");
                }
            });

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.SHIFT_DOWN_MASK, false), "left");

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.SHIFT_DOWN_MASK, false), "right");

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.SHIFT_DOWN_MASK, true), "released");

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.SHIFT_DOWN_MASK, true), "released");
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}
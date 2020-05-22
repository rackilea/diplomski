import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
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

        private JLabel up;
        private JLabel down;
        private JLabel left;
        private JLabel right;

        public TestPane() {

            up = createLabel("UP");
            down = createLabel("DOWN");
            left = createLabel("LEFT");
            right = createLabel("RIGHT");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.CENTER;
            add(up, gbc);
            gbc.gridy = 2;
            add(down, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            add(left, gbc);
            gbc.gridx = 2;
            add(right, gbc);

            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up-press", new HighlightAction(up, true));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_KP_UP, 0, false), "up-press", new HighlightAction(up, true));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down-press", new HighlightAction(down, true));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_KP_DOWN, 0, false), "down-press", new HighlightAction(down, true));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left-press", new HighlightAction(left, true));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_KP_LEFT, 0, false), "left-press", new HighlightAction(left, true));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right-press", new HighlightAction(right, true));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_KP_RIGHT, 0, false), "right-press", new HighlightAction(right, true));

            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "up-release", new HighlightAction(up, false));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_KP_UP, 0, true), "up-release", new HighlightAction(up, false));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "down-release", new HighlightAction(down, false));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_KP_DOWN, 0, true), "down-release", new HighlightAction(down, false));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "left-release", new HighlightAction(left, false));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_KP_LEFT, 0, true), "left-release", new HighlightAction(left, false));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right-release", new HighlightAction(right, false));
            registerKeyBinding(KeyStroke.getKeyStroke(KeyEvent.VK_KP_RIGHT, 0, true), "right-release", new HighlightAction(right, false));
        }

        public void registerKeyBinding(KeyStroke keyStroke, String name, Action action) {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(keyStroke, name);
            am.put(name, action);
        }

        public JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            return label;
        }

        public class HighlightAction extends AbstractAction {

            private JLabel label;
            private boolean on;

            public HighlightAction(JLabel label, boolean on) {
                this.label = label;
                this.on = on;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (on) {
                    label.setBackground(Color.RED);
                    label.repaint();
                } else {
                    label.setBackground(null);
                }
            }

        }

    }

}
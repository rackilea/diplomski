import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class KeyboardTest {

    public static void main(String[] args) {
        new KeyboardTest();
    }

    public KeyboardTest() {
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

        public TestPane() {
            JButton btnA = createButton("A");
            JButton btnB = createButton("B");
            JButton btnC = createButton("C");
            JButton btnD = createButton("D");
            JButton btnE = createButton("E");

            add(btnA);
            add(btnB);
            add(btnC);
            add(btnD);
            add(btnE);

            addKeyBinding(btnA, "A", KeyEvent.VK_A);
            addKeyBinding(btnB, "B", KeyEvent.VK_B);
            addKeyBinding(btnC, "C", KeyEvent.VK_C);
            addKeyBinding(btnD, "D", KeyEvent.VK_D);
            addKeyBinding(btnE, "E", KeyEvent.VK_E);

        }

        protected JButton createButton(String text) {
            JButton btn = new JButton(text);
            btn.setFocusable(false);
            return btn;
        }

        protected void addKeyBinding(JButton btn, String name, int virtualKey) {
            ActionMap am = getActionMap();
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);

            im.put(KeyStroke.getKeyStroke(virtualKey, 0, false), name + ".pressed");
            im.put(KeyStroke.getKeyStroke(virtualKey, 0, true), name + ".released");

            am.put(name + ".pressed", new KeyAction(btn, true));
            am.put(name + ".released", new KeyAction(btn, false));
        }

    }

    public class KeyAction extends AbstractAction {

        private JButton btn;
        private boolean highlight;

        public KeyAction(JButton btn, boolean highlight) {
            this.btn = btn;
            this.highlight = highlight;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (highlight) {
                btn.getModel().setPressed(true);
                btn.setBackground(Color.RED);
                btn.setOpaque(true);
            } else {
                btn.getModel().setPressed(false);
                btn.setBackground(null);
                btn.setOpaque(false);
            }
        }

    }

}
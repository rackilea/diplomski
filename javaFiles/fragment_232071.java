import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class KeyBindingsTest {
    JFrame frame = new JFrame();

    public KeyBindingsTest() {
        ActionMap actionMap = frame.getRootPane().getActionMap();
        InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        for (Keys direction : Keys.values()) {
            actionMap.put(direction.getText(), new KeyBinding(direction.getText()));
            inputMap.put(direction.getKeyStroke(), direction.getText());
        }

        frame.getRootPane().setActionMap(actionMap);
        frame.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        frame.setVisible(true);
    }

    private class KeyBinding extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public KeyBinding(String text) {
            super(text);
            putValue(ACTION_COMMAND_KEY, text);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            System.out.println("Key Binding: " + action);
        }
    }

    public static void main(String... args) {
        new KeyBindingsTest();
    }

    private enum Keys {
        ESCAPE ("Escape",    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0)),
        CTRLC  ("Control-C", KeyStroke.getKeyStroke(KeyEvent.VK_C,      KeyEvent.CTRL_DOWN_MASK)),
        CTRLP  ("Control-P", KeyStroke.getKeyStroke(KeyEvent.VK_P,      KeyEvent.CTRL_DOWN_MASK)),
        UP     ("Up",        KeyStroke.getKeyStroke(KeyEvent.VK_UP,     0)),
        DOWN   ("Down",      KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,   0)),
        LEFT   ("Left",      KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,   0)),
        RIGHT  ("Right",     KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,  0));

        private String text;
        private KeyStroke keyStroke;

        private Keys(String text, KeyStroke keyStroke) {
            this.text = text;
            this.keyStroke = keyStroke;
        }

        public String getText() {
            return text;
        }

        public KeyStroke getKeyStroke() {
            return keyStroke;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
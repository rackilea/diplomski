import static javax.swing.KeyStroke.getKeyStroke;
import static java.awt.event.KeyEvent.*;
...
    private void remapShiftedArrowKeys() {
        InputMap map = (InputMap)UIManager.get("ScrollPane.ancestorInputMap");
        map.put(getKeyStroke(VK_DOWN, SHIFT_DOWN_MASK), "scrollDown");
        map.put(getKeyStroke(VK_UP, SHIFT_DOWN_MASK), "scrollUp");
        map.put(getKeyStroke(VK_LEFT, SHIFT_DOWN_MASK), "scrollHome");
        map.put(getKeyStroke(VK_RIGHT, SHIFT_DOWN_MASK), "scrollEnd");
    }
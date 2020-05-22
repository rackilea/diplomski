public class MyMenuShortcut extends MenuShortcut {

    int key1;
    int key2;

    ...

    public MyMenuShortcut(int key1, int key2, boolean useShiftModifier) {
        super(key1, useShiftModifier);
        this.key1 = key1;
        this.key2= key2;
    }

    // toString() must be overriden to display in the menu

    public String toString() {
    int modifiers = 0;
    if (!GraphicsEnvironment.isHeadless()) {
        modifiers = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
    }
    if (usesShiftModifier()) {
        modifiers |= Event.SHIFT_MASK;
    }
    return KeyEvent.getKeyModifiersText(modifiers) + "+" +
            KeyEvent.getKeyText(key1) + "+" + KeyEvent.getKeyText(key2);
}
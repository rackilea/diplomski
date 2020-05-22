import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.Serializable;

public class KeyboardCommand extends CommandBase {

    private static final long serialVersionUID = 8L;
    // private KeyEvent event;
    private char keyChar;
    private int keyCode;
    private int extendedKeyCode;

    public KeyboardCommand(KeyEvent event) {
        super(ActionType.KeyboardAction);
        // this.event = event;
        keyChar = event.getKeyChar();
        keyCode = event.getKeyCode();
        extendedKeyCode = event.getExtendedKeyCode();
    }

    /**
     * Presses and releases the event's key
     */
    public void key(Robot operator, int delay) {
        // operator.keyPress(event.getExtendedKeyCode());
        operator.keyPress(extendedKeyCode);
        operator.delay(delay);
        // operator.keyRelease(event.getExtendedKeyCode());
        operator.keyRelease(extendedKeyCode);
    }

    /**
     * Performs the keyboard action
     */
    @Override
    public void doAction(Robot operator) {
        // boolean isUpperCase = Character.isUpperCase(event.getKeyChar());
        boolean isUpperCase = Character.isUpperCase(keyChar);
        if (isUpperCase)
            operator.keyPress(KeyEvent.SHIFT_DOWN_MASK);
        key(operator, 20);
        if (isUpperCase)
            operator.keyRelease(KeyEvent.SHIFT_DOWN_MASK);
        System.out.println("Keyboard command executed");
    }

    @Override
    public String toString() {
        // return "KeyCode: " + this.event.getKeyCode() + ", keyChar: " + this.event.getKeyChar();
        return "KeyCode: " + keyCode + ", keyChar: " + keyChar;
    }
}
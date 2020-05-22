/** Manager for all keyboard input. Only singleton instance is allowed. */
public class KeyboardListener implements KeyListener{

    /** The up key code */
    public static final int UP = KeyEvent.VK_UP;
    /** The left key code */
    public static final int LEFT = KeyEvent.VK_LEFT;
    /** The down key code */
    public static final int DOWN = KeyEvent.VK_DOWN;
    /** The right key code */
    public static final int RIGHT = KeyEvent.VK_RIGHT;
    /** The "a" (main button / weak confirm button) key code */
    public static final int A = KeyEvent.VK_Z;
    /** The "b" (secondary button / weak decline button) key code */
    public static final int B = KeyEvent.VK_X;
    /** The "start" (tertiary / strong confirm button) key code */
    public static final int START = KeyEvent.VK_ENTER;
    /** The "esc" (tertiary / strong decline button) key code */
    public static final int ESC = KeyEvent.VK_ESCAPE;

    /** The singleton instance of keyboardListener to be used by all frames */
    protected static final KeyboardListener instance = new KeyboardListener();

    /** Constructor for KeyboardListener */
    private KeyboardListener(){}

    /** The frame this KeyboardListener is listening to */
    private Frame frame; //Note - Frame is a class I've written, Frame extends JFrame

    /** Set the Frame the KeyboardListener is listening to */
    public static void setFrame(Frame f){
        instance.frame = f;
        instance.frame.addKeyListener(instance);
    }

    /** Unused */
    @Override
    public void keyTyped(KeyEvent e) {}

    /** Handle key presses */
    @Override
    public void keyPressed(KeyEvent e) { 
        int keyCode = e.getKeyCode();
        if(keyCode == UP){
          //Handle push of the up arrow
        }
        //etc....
    }

    /** Unused */
    @Override
    public void keyReleased(KeyEvent e) {};
}
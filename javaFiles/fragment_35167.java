public class Reg extends JDialog {
    public static final int OK = 0;
    public static final int CANCEL = 1;

    private int disposeState = CANCEL;

    //...

    public int getDisposeState() {
        return disposeState
    }

    public void setDisposeState(int state) {
        disposeState = state;
    }
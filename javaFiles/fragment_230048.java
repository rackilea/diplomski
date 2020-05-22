public class Two {
    private One one;
    private GetKeyStroke keyListener;

    public Two( final One one ) {
        this.one = one;
        keyListener = one.getKeyListener();
    }

    public someMehod() {
        one.removeKeyListener(keyListener);
    }
}
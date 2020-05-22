public class One {
    private GetKeyStroke keyListener;

    public One() {
        keyListener = new GetKeyStroke(this);
        addKeyListener(keyListener);
    }

    public GetKeyStroke getKeyListener(){
        return keyListener;
    }
}
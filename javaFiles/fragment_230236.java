public abstract class KeyActionListener {
    protected int keyCode;
    public KeyActionListener(int keyCode) {
        this.keyCode = keyCode;
    }
    public void setKeyCode(int keyCode){
        this.keyCode = keyCode;
    }
    public int getKeyCode(){
        return this.keyCode;
    }
    public abstract void onKeyDown();
    public abstract void onKeyUp();
    public abstract void onKeyHolding();
}
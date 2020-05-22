public abstract class OwnPane extends Pane {
    protected volatile boolean isRoot = false;

    public void setAsRoot(){
        isRoot = true;
    }

    public void unsetAsRoot(){
        isRoot = false;
    }
}
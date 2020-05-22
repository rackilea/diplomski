public interface BooleanInterface {
    public void setBoolean(boolean bool);
}

public class GUI extends JFrame implements BooleanInterface {
    boolean bool;

    @Override
    public void setBoolean(boolean bool) {
        this.bool = bool;
    }
}

public BoxListener implements ActionListener {
    BooleanInterface boolFace;

    public BoxListener(BooleanInterface boolFace) {
        this.boolFace = boolFace;
    }
}
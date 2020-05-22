public class Box extends JComponent implements ... {

    public Box(int axis) {
        super();
        super.setLayout(new BoxLayout(this, axis));
    }
}
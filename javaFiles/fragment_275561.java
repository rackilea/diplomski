public class TwoListener implements MouseMotionListener, MouseListener {

    private final JFrame    f;
    private final TextField tf;

    public TwoListener() {
        f = new JFrame("Two Listeners Example");
        tf = new TextField(30);

        launchFrame();
    }

    public void launchFrame() {
        final Label label = new Label("Click and Drag the mouse");

        // add components to the frame
        f.add(label, BorderLayout.NORTH);
        f.add(tf, BorderLayout.SOUTH);

        //add this object to a listener

        f.addMouseMotionListener(this);
        f.addMouseListener(this);

        //set size of the frame

        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // SOMEWHAT IMPORTANT
        f.setSize(300, 200);
        f.setVisible(true);
    }


    @Override public void mouseEntered(final MouseEvent e) {
        final String s = "Mouse moved";
        tf.setText(s);
    }

    @Override public void mouseDragged(final MouseEvent e) {

        final String s = "Mouse Dragging: X " + e.getX() + " Y: " + e.getY();
        tf.setText(s);
    }

    @Override public void mouseExited(final MouseEvent e) {
        final String s = "mouse has exited the building";
        tf.setText(s);
    }

    //unimplemented methods
    @Override public void mouseClicked(final MouseEvent e) {}
    @Override public void mousePressed(final MouseEvent e) {}
    @Override public void mouseReleased(final MouseEvent e) {}
    @Override public void mouseMoved(final MouseEvent e) {}

    public static void main(final String[] args) {
        new TwoListener();

    }

}
public class ResizableButton extends JButton {

    private Point grabbedPoint;
    private Dimension grabbedDimension;

    private boolean isHeld = false;

    public ResizableButton(String name) {
        super(name);
        addMouseListener(clickListener);
        addMouseMotionListener(moveListener);
    }

    private MouseMotionListener moveListener = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (isHeld) {
                Point newP = e.getPoint();
                setPreferredSize(new Dimension(grabbedDimension.width
                        - (grabbedPoint.x - newP.x), grabbedDimension.height
                        - (grabbedPoint.y - newP.y)));
                setBounds(new Rectangle(getLocation(), ResizableButton.this
                        .getPreferredSize()));
            }
        }
    };

    private MouseListener clickListener = new MouseAdapter() {

        @Override
        public void mouseReleased(MouseEvent e) {
            isHeld = false;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            isHeld = true;
            grabbedPoint = e.getPoint();
            grabbedDimension = ((JButton) e.getSource()).getSize();
        }
    };
}
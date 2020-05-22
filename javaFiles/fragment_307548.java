public class MovableResizableButton extends JButton {

    private boolean isHeld;
    private Point pointClicked;
    private Dimension startingSize;

    public MovableResizableButton(String name) {
        super(name);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isHeld) {
                Dimension newSize = getPreferredSize();
                Point newPoint = getLocation();
                if ((e.getModifiersEx() & InputEvent.ALT_DOWN_MASK) == InputEvent.ALT_DOWN_MASK) {
                    newSize = new Dimension(startingSize.width - (pointClicked.x - e.getPoint().x),
                                            startingSize.height -(pointClicked.y - e.getPoint().y));
                }else {
                    Point startPoint = getLocation();
                    newPoint = new Point(startPoint.x - (pointClicked.x - e.getPoint().x), 
                                         startPoint.y - (pointClicked.y - e.getPoint().y));
                }
                setPreferredSize(newSize);
                setBounds(new Rectangle(newPoint, getPreferredSize()));
                }
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pointClicked = e.getPoint();
                startingSize = getSize();
                isHeld = true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                isHeld = false;
            }
        });
    }
}
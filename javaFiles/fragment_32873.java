MouseInputAdapter mia = new MouseInputAdapter()
{
    Point location;
    Point pressed;

    public void mousePressed(MouseEvent me)
    {
        pressed = me.getLocationOnScreen();
        Window window = SwingUtilities.windowForComponent(me.getComponent());
        location = window.getLocation();
    }

    public void mouseDragged(MouseEvent me)
    {
        Point dragged = me.getLocationOnScreen();
        int x = (int)(location.x + dragged.getX() - pressed.getX());
        int y = (int)(location.y + dragged.getY() - pressed.getY());
        Window window = SwingUtilities.windowForComponent(me.getComponent());
        window.setLocation(x, y);
     }
};

panel.addMouseListener(mia);
panel.addMouseMotionListener(mia);
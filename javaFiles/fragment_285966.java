public void installUI(JComponent c) {
    super.installUI(c);
    ((JLayer<?>) c).setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
}

protected void processMouseEvent(MouseEvent e, JLayer l) {
    if (e.getID() == MouseEvent.MOUSE_CLICKED) {
        Point pt = e.getPoint();
        if (pt.x >= xTemplateHyperlink  &&  pt.x <= (xTemplateHyperlink + widthTemplateHyperlink)) {
            System.out.println("clicked");
        }
    }
}
MouseMotionListener listener = new MouseMotionAdapter() {
    @Override
    public void mouseMoved(MouseEvent me) {
        me = SwingUtilities.convertMouseEvent(
            me.getComponent(), me, frame);

        System.out.println("Mouse Move");
        xyMouseLabel.x = me.getX();
        xyMouseLabel.y = me.getY();
        xyMouseLabel.repaint();
    }
};

menu.addMouseMotionListener(listener);
for (Component child : menu.getComponents()) {
    child.addMouseMotionListener(listener);
}
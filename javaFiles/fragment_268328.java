final JList list = new JList(new String[] {"a","b","c"});
list.addMouseMotionListener(new MouseMotionListener() {
    @Override
    public void mouseMoved(MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        // only display a hand if the cursor is over the items
        final Rectangle cellBounds = list.getCellBounds(0, list.getModel().getSize() - 1);
        if (cellBounds != null && cellBounds.contains(x, y)) {
            list.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            list.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
});
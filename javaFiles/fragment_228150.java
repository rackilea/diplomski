final JTree tree = ...;

MouseListener ml = new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        int selRow = tree.getRowForLocation(e.getX(), e.getY());
        TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
        if(selRow != -1) {
            if(e.getClickCount() == 1) {
                mySingleClick(selRow, selPath);
            }
            else if(e.getClickCount() == 2) {
                myDoubleClick(selRow, selPath);
            }
        }
    }
};
tree.addMouseListener(ml);
tree.addMouseListener(new MouseAdapter() {
    @Override
        public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            int row = tree.getClosestRowForLocation(e.getX(), e.getY());
            tree.setSelectionRow(row);
            if (tree.getSelectionPath().getPathCount() == 2) {
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
});
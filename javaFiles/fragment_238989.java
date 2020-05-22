aTable.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
        int r = aTable.rowAtPoint(e.getPoint());
        if (r >= 0 && r < clt.getRowCount()) {
            aTable.setRowSelectionInterval(r, r);
        } else {
            aTable.clearSelection();
        }
    }
});
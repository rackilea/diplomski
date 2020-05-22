MouseListener l = new MouseAdapter() {

    @Override
    public void mousePressed(MouseEvent e) {
        Rectangle lastRow = table.getCellRect(table.getRowCount() - 1, 0, false);
        if (e.getY() < lastRow.y + lastRow.height) return;
        System.out.println(table);
        table.getSelectionModel().setAnchorSelectionIndex(table.getRowCount()-1);
    }

};
table.addMouseListener(l);
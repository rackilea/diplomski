table.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int r = table.rowAtPoint(e.getPoint());
                if (r >= 0 && r < table.getRowCount()) {
                    table.setRowSelectionInterval(r, r);
                } else {
                    table.clearSelection();
                }

                int rowindex = table.getSelectedRow();
                if (rowindex < 0)
                    return;
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
                    JPopupMenu popup = popupForTable;
                    popup.show(e.getComponent(), e.getX(), e.getY());
                    table.setRowSelectionInterval(r, r);
                }
            }
});
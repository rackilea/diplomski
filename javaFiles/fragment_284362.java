public static class EventHook implements MouseListener {

    private JTableHeader header;
    private MouseListener delegate;

    public EventHook(JTableHeader header) {
        this.header = header;
        installHook();
    }

    protected void installHook() {
        MouseListener[] listeners = header.getMouseListeners();
        for (int i = 0; i < listeners.length; i++) {
            MouseListener l = listeners[i];
            if (l.getClass().getName().contains("TableHeaderUI")) {
                this.delegate = l;
                listeners[i] = this;
            }
            header.removeMouseListener(l);
        }
        for (MouseListener l : listeners) {
            header.addMouseListener(l);
        }
    }

    public void uninstallHook() {
        MouseListener[] listeners = header.getMouseListeners();
        for (int i = 0; i < listeners.length; i++) {
            MouseListener l = listeners[i];
            if (l == this) {
                listeners[i] = delegate;
            }
            header.removeMouseListener(l);
        }
        for (MouseListener l : listeners) {
            header.addMouseListener(l);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // sort before calling super
        sort(e);
        delegate.mouseReleased(e);
    }

    private void sort(MouseEvent e) {
        if (!header.isEnabled()) {
            return;
        }
        // do nothing if dragged
        if (header.getDraggedDistance() != 0) {
            return;
        }
        if (e.getClickCount() % 2 == 1 &&
                SwingUtilities.isLeftMouseButton(e)) {
            JTable table = header.getTable();
            RowSorter sorter;
            if (table != null && (sorter = table.getRowSorter()) != null) {
                int columnIndex = header.columnAtPoint(e.getPoint());
                if (columnIndex != -1) {
                    columnIndex = table.convertColumnIndexToModel(
                            columnIndex);
                    sorter.toggleSortOrder(columnIndex);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // swallow the clicked - want to trigger sort on released
    }

    @Override
    public void mousePressed(MouseEvent e) {
        delegate.mousePressed(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        delegate.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        delegate.mouseExited(e);
    }

}
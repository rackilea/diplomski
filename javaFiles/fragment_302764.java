@Override
public synchronized void dragOver(DropTargetDragEvent dtde) {
    Point point = dtde.getLocation();
    int row = table.rowAtPoint(point);
    if (row < 0) {
        dtde.rejectDrag();
        table.clearSelection();
    } else {
        dtde.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
        table.setRowSelectionInterval(row, row);
    }
}
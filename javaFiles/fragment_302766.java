@Override
public synchronized void dragOver(DropTargetDragEvent dtde) {
    Point point = dtde.getLocation();
    int row = table.rowAtPoint(point);
    if (row < 0) {
        table.clearSelection();
    } else {
        table.setRowSelectionInterval(row, row);
    }
    dtde.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
}
@Override
public synchronized void drop(DropTargetDropEvent dtde) {    
    Point point = dtde.getLocation();
    int row = table.rowAtPoint(point);
    if (row >= 0) {
        if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
            Transferable t = dtde.getTransferable();
            List fileList = null;
            try {
                fileList = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
                if (fileList.size() > 0) {
                    table.clearSelection();
                    Point point = dtde.getLocation();
                    int row = table.rowAtPoint(point);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setValueAt(f.getAbsolutePath(), row, 0);
                    model.setValueAt(f.length(), row, 2);
                }
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            dtde.rejectDrop();
        }
    } else {
        dtde.rejectDrop();
    }
}
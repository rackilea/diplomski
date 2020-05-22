@Override
public synchronized void drop(DropTargetDropEvent dtde) {    
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
                for (Object value : fileList) {
                    if (value instanceof File) {
                        File f = (File) value;
                        if (row < 0) {
                            System.out.println("addRow");
                            model.addRow(new Object[]{f.getAbsolutePath(), "", f.length(), "", ""});
                        } else {
                            System.out.println("insertRow " + row);
                            model.insertRow(row, new Object[]{f.getAbsolutePath(), "", f.length(), "", ""});
                            row++;
                        }
                    }
                }
            }
        } catch (UnsupportedFlavorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } else {
        dtde.rejectDrop();
    }
}
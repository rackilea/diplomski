List fileList = null;
try {
    fileList = (List) t
        .getTransferData(DataFlavor.javaFileListFlavor);
} catch (UnsupportedFlavorException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
File f = (File) fileList.get(0);
table.setValueAt(f.getAbsolutePath(), row, column);
table.setValueAt(f.length(), row, column + 1);
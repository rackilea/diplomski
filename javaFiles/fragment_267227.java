private class FileTransferHandler extends TransferHandler {
    @Override
    protected Transferable createTransferable(JComponent c) {
        List<File> files = new ArrayList<>();
        files.add(currentPDF.getFile());
        return new FileTransferable(files);
    }
    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }        
}
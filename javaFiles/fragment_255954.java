private class FileLoader extends SwingWorker<String, Void> {

    private final JFrame frame;
    private final File file;        

    public SdfLoader(JFrame frame, File file) {            
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        this.frame = frame;
        this.file = file;
    }

    @Override
    public String doInBackground() throws IOException {

            String result = null; 
            // read file and set result;
        return result;
    }

    @Override
    public void done() {
        try {
            String result = get();
            //do stuff 
        } catch (ExecutionException | InterruptedException ex) {
            // display error
            JOptionPane.showMessageDialog(SdfViewer.this,
                    ioException.getMessage(),
                    "Error opening file",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            frame.setCursor(Cursor.getDefaultCursor());
        }
    }

}
class FileUploader implements Receiver {
    private File file;
    private String BASE_PATH="C:\";

    public OutputStream receiveUpload(String filename,
                                  String mimeType) {
        // Create upload stream
        FileOutputStream fos = null; // Stream to write to
        try {
            // Open the file for writing.
            file = new File(BASE_PATH + filename);
            fos = new FileOutputStream(file);
        } catch (final java.io.FileNotFoundException e) {
            new Notification("Could not open file<br/>",
                         e.getMessage(),
                         Notification.Type.ERROR_MESSAGE)
            .show(Page.getCurrent());
            return null;
        }
        return fos; // Return the output stream to write to
    }
};
private class InputStreamMunger implements TypedOutput {

    private InputStream is;
    private String mimeType;
    private Long fileLength;
    private String fileName;
    private static final int BUFFER_SIZE = 4096;


    public InputStreamMunger(InputStream is, String mimeType, Long fileLength,
            String fileName) {
        this.is = is;
        this.fileLength = fileLength;
        this.mimeType = mimeType;
        this.fileName = fileName;
    }

    @Override
    public String mimeType() {
        return mimeType;
    }

    @Override
    public long length() {
        return fileLength;
    }

    @Override
    public void writeTo(OutputStream out) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        try {
            int read;
            while ((read = is.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } finally {
            is.close();
        }
    }

    public String fileName() {
        return fileName;
    }

}
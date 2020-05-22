public final static int MAX_SIZE = 75000;

private void writeToFile(InputStream uploadedInputStream,String uploadedFileLocation) {
    try {
        OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
        int read = 0;
        int size = 0;
        byte[] bytes = new byte[1024];
        out = new FileOutputStream(new File(uploadedFileLocation));
        while (size < MAX_SIZE && (read = uploadedInputStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
            size += read;
        }
        out.flush();
        out.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
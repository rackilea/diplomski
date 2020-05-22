private void writeToFile(InputStream uploadedInputStream,
    String uploadedFileLocation) {

    OutputStream out = null;
    try {
        out = new FileOutputStream(new File(uploadedFileLocation))
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = uploadedInputStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }

    } catch (IOException e) {

        e.printStackTrace();
    } finally {
        if (out != null) {
            try {
                out.close();
            } catch (IOException exp) {            
            }
        }
    }

}
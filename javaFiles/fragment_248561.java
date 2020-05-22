try {
    try {
        byte[] buffer = new byte[4 * 1024]; // or other buffer size
        int read;

        while ((read = selectedFileInputStream.read(buffer)) != -1) {
            outputTempFileStream.write(buffer, 0, read);
        }
        outputTempFileStream.flush();
    } finally {
        outputTempFileStream.close();
    }
} catch (Exception e) {
    e.printStackTrace(); // handle exception, define IOException and others
}
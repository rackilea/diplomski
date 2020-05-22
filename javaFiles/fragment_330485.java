final SmbFile destFile = ... //Depends on how you init SmbFile object

InputStream inputStream = ... // your InputStream with data
OutputStream outputStream = null;
try {
    outputStream = destFile.getOutputStream();

    byte[] buf = new byte[STREAM_BUFFER_SIZE];
    int read;
    while ((read = inputStream.read(buf)) > -1) {
        outputStream.write(buf, 0, read);
    }
    outputStream.flush();
} finally {
    if (inputStream != null)
        inputStream.close();
    if (outputStream != null)
        outputStream.close();
}
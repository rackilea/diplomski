// the signature of the method is complete speculation, adapt it to your needs
private void ReceiveFile(File file)
{
    FileOutputStream fos = new File(file);
    InputStream is = socket.getInputStream();
    DataInputStream wrapper = new DataInputStream(is);

    // will not work for very big files, adapt to your needs too
    long fileSize = wrapper.readLong();
    byte[] fileData = new byte[fileSize];
    is.read(fileData, 0, fileSize);
    fos.write(fileData, 0, fileSize);
}
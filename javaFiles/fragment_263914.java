private static byte[] readContentIntoByteArray(File file) {
    FileInputStream fileInputStream = null;
    byte[] bFile = new byte[(int) file.length()];
    try {
        //convert file into array of bytes
        fileInputStream = new FileInputStream(file);
        fileInputStream.read(bFile);
        fileInputStream.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
    return bFile;
}
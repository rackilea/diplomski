public static boolean write(byte[] content, File to) {
    FileOutputStream fos = new FileOutputStream(to);
    try {
        fos.write(content);
    } catch (IOException io) {
        // logging code here
        return false;
    } finally {
        closeQuietly(fos);
    }
    return true;
}
public static void closeQuietly(Closeable toClose) {
    if ( toClose == null ) { return; }
    try {
        toClose.close();
    } catch (IOException e) {
        // logging code here
    } 
}
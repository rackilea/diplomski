public static boolean copyFile(String from, String to) {
try {
    int bytesum = 0;
    int byteread = 0;
    File oldfile = new File(from);
    if (oldfile.exists()) {
        InputStream inStream = new FileInputStream(from);
        FileOutputStream fs = new FileOutputStream(to);
        byte[] buffer = new byte[1444];
        while ((byteread = inStream.read(buffer)) != -1) {
            bytesum += byteread;
            fs.write(buffer, 0, byteread);
        }
        inStream.close();
        fs.close();
    }
    return true;
} catch (Exception e) {
    return false;
}
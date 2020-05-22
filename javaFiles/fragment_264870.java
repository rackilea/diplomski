private byte[] readFile(String file) {
    ByteArrayOutputStream bos = null;
    try {
        File f = new File(file);
        FileInputStream fis = new FileInputStream(f);
        byte[] buffer = new byte[1024];
        bos = new ByteArrayOutputStream();
        for (int len; (len = fis.read(buffer)) != -1;) {
            bos.write(buffer, 0, len);
        }
    } catch (FileNotFoundException e) {
        System.err.println(e.getMessage());
    } catch (IOException e2) {
        System.err.println(e2.getMessage());
    }
    return bos != null ? bos.toByteArray() : null;
}
private void writeToOutputStream(String resource, OutputStream oos) throws Exception {

    File f = new File(this.definePathToPublicResources() + resource);

    byte[] buf = new byte[8192];

    InputStream is = new FileInputStream(f);

    int c = 0;

    while ((c = is.read(buf, 0, buf.length)) > 0) {
        oos.write(buf, 0, c);
        oos.flush();
    }

    oos.close();
    is.close();

}
public static byte[] convertImageByte(URL url) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    InputStream is = null;
    try {
        is = new BufferedInputStream(url.openStream());
        byte[] byteChunk = new byte[4096];
        int n;
        while ( (n = is.read(byteChunk)) > 0 ) {
            baos.write(byteChunk, 0, n);
        }   
        return baos.toByteArray();
    }
    catch (IOException e) {e.printStackTrace ();}
    finally {
        if (is != null) { is.close(); }
    }
    return null;
}
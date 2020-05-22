public static void stream(InputStream in, OutputStream out)
        throws IOException {
    byte[] buf = new byte[1024];
    int bytesRead = 0;

    try {

        while (-1 != (bytesRead = in.read(buf, 0, buf.length))) {
            out.write(buf, 0, bytesRead);
        }

    } catch (IOException e) {
        log.error("Error with streaming op: " + e.getMessage());
        throw (e);
    } finally {
                    try{
           in.close();
           out.flush();
           out.close();
                    } catch (Exception e){}//Ignore
    }
}
InputStream in = null;
OutputStream out = null;
try {
    in = new FileInputStream("a.dat");
    out = new FileInputStream("b.dat");
    byte[] buffer = new byte[4*1024*1042]; //4 MiB
    for ( int len = 0; (len = in.read(buffer)) != -1; ) {
       out.write(buffer, 0, len);
    }
} finally {
    if ( in != null )
       try { in.close() } catch (IOException ignore) {}
    if ( out != null )
       try { out.close() } catch (IOException ignore) {}
}
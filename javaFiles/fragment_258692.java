public static void copyStream(final InputStream in, final OutputStream out)
    throws IOException
{
    final byte[] buf = new byte[32768]; // or more, or less; size appropriately
    int nrBytes;

    while ((nrBytes = in.read(buf)) != -1)
        out.write(buf, 0, nrBytes);

    out.flush();
}
private InputStream convertZipInputStreamToInputStream(ZipInputStream in, ZipEntry entry, String encoding) throws IOException
{
    final int BUFFER = 2048;
    int count = 0;
    byte data[] = new byte[BUFFER];
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    while ((count = in.read(data, 0, BUFFER)) != -1) {
        out.write(data);
    }       
    InputStream is = new ByteArrayInputStream(out.toByteArray());
    return is;
}
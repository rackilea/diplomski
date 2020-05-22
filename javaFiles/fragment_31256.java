public void copyStream(InputStream input, OutputStream output) throws IOException
{
    byte[] buffer = new byte[32*1024];
    int bytesRead;
    while ((bytesRead = input.read(buffer, 0, buffer.length)) > 0)
    {
        output.write(buffer, 0, bytesRead);
    }
}
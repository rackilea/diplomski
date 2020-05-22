void read(InputStream inputStream, int bufferSize) throws IOException
{
    byte[] buffer = new byte[bufferSize];
    int read;
    while ((read = inputStream.read(buffer)) != -1)
    {
       // do some work
    }
}
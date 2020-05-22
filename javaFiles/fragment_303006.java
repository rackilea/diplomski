void read2(InputStream inputStream, int bufferSize) throws IOException
{
    BufferedInputStream bis = new BufferedInputStream(inputStream, bufferSize);
    try
    {
        byte[] buffer = new byte[bufferSize];
        int read;
        while ((read = bis .read(buffer)) != -1)
        {
            // do some work
        }
    }
    finally
    {
        bis.close();
    }
}
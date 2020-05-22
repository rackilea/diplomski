class OutputStreamWithZipMd5Aes
{
    ...
    OutputStream os;
    ...
    public void write(byte[] buffer, int pos, int n) throws IOException
    {
        os.write(buffer,pos,n);
    }

    public void close() throws IOException
    {
        os.close();
    }
    ...
}
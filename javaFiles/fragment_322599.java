class OutputStreamWithZipMd5Aes extends OutputStream
{
    ...
    OutputStream os;
    ...

    @Override
    public void close() throws IOException
    {
        os.close();
    }
    ...
}
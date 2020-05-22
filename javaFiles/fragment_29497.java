public static byte[] readExactly(InputStream input, int size) throws IOException
{
    byte[] data = new byte[size];
    int index = 0;
    while (index < size)
    {
        int bytesRead = input.read(data, index, size - index);
        if (bytesRead < 0)
        {
            throw new IOException("Insufficient data in stream");
        }
        index += size;
    }
    return data;
}
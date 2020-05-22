private native int readBytes(byte b[], int off, int len)
    throws IOException;

public int read(byte b[])
    throws IOException
{
    return readBytes(b, 0, b.length);
}
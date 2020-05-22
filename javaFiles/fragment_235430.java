public class OddByteOutputStream extends FilterOutputStream
{
    public OddByteOutputStream(OutputStream output)
    {
        super(output);
    }

    @Override
    public void write(int b)
    {
        if ((b & 1) == 1)
        {
            out.write(b);
        }
    }
}
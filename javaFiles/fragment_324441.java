public class SafeHttpHeaderReader
{   
    public static final int MAX_READ = 8*1024;
    private InputStream stream;
    private int bytesRead;

    public SafeHttpHeaderReader(InputStream stream)
    {
        this.stream = stream;
        bytesRead = 0;
    }

    public boolean hasReachedMax()
    {
        return bytesRead >= MAX_READ;
    }

    public String readLine() throws IOException, Http400Exception
    {
        String s = "";

        while(bytesRead < MAX_READ)
        {
            String n = read();

            if(n.equals( "" ))
                break;

            if(n.equals( "\r" ))
            {
                if(read().equals( "\n" ))
                    break;

                throw new Http400Exception();
            }
            s += n;
        }

        return s;
    }

    private String read() throws IOException
    {
        byte b = readByte();

        if(b == -1)
            return "";

        return new String( new byte[]{b} , "ASCII");
    }

    private byte readByte() throws IOException
    {
        byte b = (byte) stream.read();
        bytesRead ++;
        return b;
    }
}
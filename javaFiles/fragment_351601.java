public class DBOutputStream extends OutputStream
{
    private String buffer;
    private DBConnClass db;

    public DBOutputStream (DBConnClass dbConn)
    {
        buffer = "";
        db = dbConn;
    }

    public void write(int b)
    {
        byte[] bytes = new byte[1];
        bytes[0] = (byte) (b & 0xff);
        buffer = buffer + new String(bytes);

        if (buffer.endsWith("\n"))
        {
            buffer = buffer.substring (0, buffer.length () - 1);
            flush ();
        }
    }   
    public void flush()
    {
        // Commit the buffer to db here
        buffer = "";
    }
}
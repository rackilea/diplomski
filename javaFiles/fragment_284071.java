public class FileManager
{
    private final FileWriter writer = new FileWriter("SomeFile.txt");
    private final object sync = new object();

    public void writeBuffer(string buffer)
    {
        synchronized(sync)
        {
            writer.write(buffer.getBytes());
        }
    }        

    public void copyAndCompress()
    {
        synchronized(sync)
        {
            // copy and/or compress
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReaderBuffer
{
    private BufferedReader reader;

    private LinkedList<String> history = new LinkedList<String>();
    private LinkedList<String> future = new LinkedList<String>();

    public ReaderBuffer(BufferedReader reader) 
    {
        this.reader = reader;
    }

    public String readLine()
    throws IOException
    {
        String line = null;

        if (future.size() > 0)
            line = future.removeFirst();

        if (line == null)
            line = reader.readLine();

        if (line != null)
            history.add(line);

        return line;
    }

    public void rewind(int numLines) 
    {
        for (int ii = 0 ; ii < numLines ; ii++) 
            future.addFirst(history.removeLast());
    }
}
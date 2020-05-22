public class ProcessOutputReader
{
    public void run()
    { 
        int ch;

        try
        { 
            BufferedReader reader = new BufferedReader(new InputStreamReader(inpStream));
            // The output can be of any size. So read in chunks
            String line = reader.readLine();
            while(line != null)
            {
                // handle line
                line = reader.readLine();
            }

        }
        catch (Exception e)
        {
            // handle exceptions
        }
    }
}
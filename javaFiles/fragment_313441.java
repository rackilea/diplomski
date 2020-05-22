public class MyObjectReader implements Closeable
{
  private BufferredReader reader;

  public MyObjectReader(Reader reader)
  {
    this.reader = new BufferredReader(reader);
  }

  public MyObject read() throws IOException
  {
    String line = reader.readLine();

    if (line != null)
    {
      String[] tokens = line.split(",");

      if (tokens.length < 3)
      {
        throw new IOException("Invalid line encountered: " + line);
      }

      return new MyObject(tokens[0], tokens[1], tokens[2]);
    }
    else
    {
      return null;
    }
  }

  public void close() throws IOException
  {
    this.reader.close();
  }
}
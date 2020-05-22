public class StreamConsumer extends Thread
{
  private final InputStream _input;

  public StreamConsumer(final InputStream inputStream)
  {
    super();

    _input = inputStream;

    setDaemon(true);
  }


  @Override
  public void run()
  {
    // TODO your code to read the stream
  }
}
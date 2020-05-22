import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

class InterruptInput
{

  private static final String EOF = new String();

  private final SynchronousQueue<String> pipe = new SynchronousQueue<String>();

  private final BufferedReader input;

  private final long timeout;

  InterruptInput(BufferedReader input, long timeout)
  {
    this.input = input;
    this.timeout = timeout;
  }

  public static void main(String... argv)
    throws Exception
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    InterruptInput input = 
      new InterruptInput(in, 5000);
    input.read();
  }

  void read()
    throws InterruptedException
  {
    System.out.println("Enter lines of input (or empty line to terminate):");
    Thread t = new Consumer();
    t.start();
    while (true) {
      String line = pipe.poll(timeout, TimeUnit.MILLISECONDS);
      if (line == EOF)
        break;
      if (line == null) {
        System.out.println("Input timed-out.");
        t.interrupt();
        break;
      }
      System.out.println("[input]: " + line);
    }
  }

  private class Consumer
    extends Thread
  {

    Consumer()
    {
      setDaemon(true);
    }

    @Override
    public void run()
    {
      while (!Thread.interrupted()) {
        String line;
        try {
          line = input.readLine();
        }
        catch (IOException ex) {
          throw new RuntimeException(ex);
        }
        try {
          if ((line == null) || (line.length() == 0)) {
            pipe.put(EOF);
            break;
          }
          else {
            pipe.put(line);
          }
        }
        catch (InterruptedException ex) {
          break;
        }
      }
    }
  }

}
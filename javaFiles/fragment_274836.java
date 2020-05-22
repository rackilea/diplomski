public class InputStreamConsumerThread extends Thread
{
  private InputStream is;
  private boolean sysout;
  private StringBuilder output = new StringBuilder();

  public InputStreamConsumerThread (InputStream is, boolean sysout)
  {
    this.is=is;
    this.sysout=sysout;
  }

  public void run()
  {
    try(BufferedReader br = new BufferedReader(new InputStreamReader(is)))
    {
      for (String line = br.readLine(); line != null; line = br.readLine())
      {
        if (sysout)
          System.out.println(line);    
        output.append(line).append("\n");
      }
    }
  }
  public String getOutput(){
    return output.toString();
  }
}
public class MyResultStream implements javax.ws.rs.core.StreamingOutput
{
  private ResultSet rs;

  public MyResultStream (ResultSet rs)
  {
    this.rs = rs;
  }

  public void write(OutputStream output)
  {
    //write any document pre-able
    // for example <results>

    while (rs.next())
    {
      //get the data from the ResultSet and write it to the output in XML form
      // for example <result><foo>bar</foo></result>
    }

    //write any document post-amble
    // for example </results>
  }
}
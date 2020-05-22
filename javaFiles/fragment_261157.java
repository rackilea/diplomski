public class df 
{

  String dt;
  String datestring;
  // Remove return type (and keep matched name) to make it a constructor.
  public df(String dtstring) throws Exception
  {
    dt=dtstring;
    ...
    datestring = newformatter.format(outpdate);
    // Constructors cannot "return"
    // return datestring;
  }

}
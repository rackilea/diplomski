public class MyCode 
{
  private GregorianCalendar example1 = null;
  private String example2 = null;

  public MyCode(Calendar example1 , String example2) 
  {
    this.example1 = example1
    this.example2 = example2;    
  }

  public GregorianCalendar getExample1 ()
  {
   return example1;
  } 

  public String getExample2 ()
  {
   return example2;
  } 
}
public class MyClass
{
  private int roll;
  private String name;
  MyClass(int roll,String name)
  {
    this.roll = roll;
    this.name = name;
  }
  @Override
  public String toString()
  {
    return "roll="+roll+",name="+name;
  }
}
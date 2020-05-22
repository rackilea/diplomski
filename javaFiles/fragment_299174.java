class Base
{
 public void superMethod()
 {
  System.out.println("Hello i m a super class method");
 }
}
class Der extends base
{
  public void method()
  {
     superMethod();// error identifier expected 
  }

  public void superMethod()
  {
     super.superMethod()
  }
}
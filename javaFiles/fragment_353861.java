interface SomeClass
{
  public void method();
}

class SomeClassWithOneParameter implements SomeClass
{
  private Parameter a;

   SomeClassWithOneParameter(Parameter a)
  {
   this.a=a;
  }
  public void method()
  {USE a parameter}
 }

class SomeClassWithTwoParameters implements SomeClass
{
  private Parameter a;
  private Parameter b;

   SomeClassWithOneParameter(Parameter a,Parameter b)
  {
   this.a=a;
   this.b=b;
  }
  public void method()
  {USE a and b parameter}
 }
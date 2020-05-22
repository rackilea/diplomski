class Base
{
  private Base()
  {

  }

  public void show()
  {
     System.out.println("Base Class Show() Method");
  }

  public static Base createBase() {
      return new Base();
  }
}
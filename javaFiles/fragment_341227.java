class MyClass
{
  private String[] s;

  private void FunnyName$Method()
  {
    s[0] = "a";
    s[1] = "b";
    s[2] = "c";
  }
  public MyClass()
  {
    FunnyName$Method();
  }
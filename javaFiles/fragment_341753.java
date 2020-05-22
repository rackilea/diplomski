Class obj2Class = object2.getClass();
try
{
  Constructor[] ctors = obj2Class.getDeclaredConstructors();
  for (Constructor cc : ctors)
  {
    System.out.println("my ctor is " + cc.toString());
  }
}
catch (Exception ex)
{
  ex.printStackTrace();
}
class A
{
  private int privateField = 3;
}

class B extends A
{}

class C extends B
{
   void m() throws NoSuchFieldException, IllegalAccessException
   {
      Field f = getClass().getSuperclass().getSuperclass().getDeclaredField("privateField");
      f.setAccessible(true); // enables access to private variables
      System.out.println(f.get(this));
   }
}
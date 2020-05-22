public class A{
  public static void xyz()
  {
    System.out.println("hello");
  }
}

public class B{
  public void callme()
  {
      A.xyz());
  }
}
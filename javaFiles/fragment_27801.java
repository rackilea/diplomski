public class MyStaticExample{
  private String instanceVariable = "Hello";
  private static String STATIC_VARIABLE = "Hello too";

  public static void staticMethod(){
    System.out.println(this.instanceVariable); // this will result in a compilation error.
    System.out.println(STATIC_VARIABLE); // this is ok
  }

  public void instanceMethod(){
    System.out.println(this.instanceVariable); // this is ok
    System.out.println(STATIC_VARIABLE); // this is ok
  }
}
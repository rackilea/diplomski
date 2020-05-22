public class OuterClass {

  public static class NestedClass {
    public static String getName() {
      //Some stuff
      return "Name";
    }
  }

  public static void main(String[] args)
  {
      System.out.println(NestedClass.getName());
  }
}
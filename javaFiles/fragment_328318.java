class TestClass {
  public Date d = new Date();

  public static void main(String[] args) throws Exception {
    MainClass.printFieldValues(new TestClass());
  }
}

public class MainClass {
  public static void printFieldValues(Object in) throws Exception {
    for (Field f : in.getClass().getFields())
      System.out.println(f.getName() + ": " + f.get(in));
  }
}
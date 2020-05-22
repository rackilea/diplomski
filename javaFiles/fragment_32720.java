public class ReflectFields {
  static class Letter {
    public int baz = 100;
  }

  static class SalesLetter extends Letter {
    public String foo = "bar";
  }

  public static void main(String[] args) throws Exception {
    // TODO: better exception handling, etc.
    SalesLetter instance = new SalesLetter();
    for (Field field : instance.getClass().getFields()) {
      System.out.format("%s = %s%n", field.getName(), field.get(instance));
    }
  }
}
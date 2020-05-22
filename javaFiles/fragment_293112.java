public abstract class MyEnum {

  private static class First extends MyEnum {

    @Override
    public String doIt() {
        return "1: " + someField; //error
    }
  }

  private static class Second extends MyEnum {

    @Override
    public String doIt() {
        return "2: " + someField; //error
    }
  }

  public static final MyEnum FIRST = new First();
  public static final MyEnum SECOND = new Second();

  private String someField;

  public abstract String doIt();
}
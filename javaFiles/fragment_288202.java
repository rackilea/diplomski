public class MyClass {

  private static int argCount;

  public static void main(String[] args) {
    argCount = args.length;
  }

  public static int getNumberOfArgs() {
    return argCount;
  }
}
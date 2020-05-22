try {
  foo = Long.parseLong(args[0]);
  bar = Long.parseLong(args[0]);
} catch (NumberFormatException e) {
  System.out.println(USAGE);
  throw HelperClass.systemExit(1);
}

...

public class HelperClass {
  public static RuntimeException systemExit(int exitCode) {
    System.exit(1);
    throw new RuntimeException("We won't get here");
  }
}
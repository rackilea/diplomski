public class FooClass {
  @Pattern(regex = Patterns.FOO_PATTERN)
  public void foo() {}
}

public class BarClass {
  @Pattern(regex = Patterns.BAR_PATTERN)
  public void bar() {}
}

public class Patterns {
  public static final String BAR_PATTERN = "bar?";
  public static final String FOO_PATTERN = "foo*";
}
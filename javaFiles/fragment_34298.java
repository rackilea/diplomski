package de.scrum_master.app;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Application {
  public static void main(String[] args) {
    new Application().doSomething();
  }

  public long doSomething() {
    return Stream.of(new String[]{"a", "b"})
      .map(new UpperCaseMapper())
      .filter(new EqualsAFilter())
      .count();
  }

  static class UpperCaseMapper implements Function<String, String> {
    @Override
    public String apply(String t) {
      return t.toUpperCase();
    }
  }

  static class EqualsAFilter implements Predicate<String> {
    @Override
    public boolean test(String t) {
      return t.equals("A");
    }
  }
}
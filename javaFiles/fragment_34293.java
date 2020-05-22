package de.scrum_master.app;

import java.util.stream.Stream;

public class Application {
  public static void main(String[] args) {
    new Application().doSomething();
  }

  public long doSomething() {
    return Stream.of(new String[]{"a", "b"})
      .map(s -> s.toUpperCase())
      .filter(s -> s.equals("A"))
      .count();
  }
}
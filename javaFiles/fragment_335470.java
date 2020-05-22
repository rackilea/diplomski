package de.scrum_master.stackoverflow;

public class NormalApp {
  static void doSomething(Normal normal) {
    System.out.println(normal.move());
    System.out.println(normal.toString());
  }

  public static void main(String[] args) {
    doSomething(() -> "xxx");
  }
}
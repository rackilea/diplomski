package de.scrum_master.app;

public class Application {
  public static void main(String[] args) {
    say("How are you?");
  }

  @Hello
  private static void say(String s) {
    System.out.println(s);
  }
}
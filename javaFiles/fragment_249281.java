package de.scrum_master.app;

@MyAnnotation
public class Application {
  private int nonStaticMember;
  private static int staticMember;

  public void doSomething() {
    System.out.println("Doing something");
    nonStaticMember = 11;
  }

  public void doSomethingElse() {
    System.out.println("Doing something else");
    staticMember = 22;
  }

  public static void main(String[] args) {
    Application application = new Application();
    application.doSomething();
    application.doSomethingElse();
  }
}
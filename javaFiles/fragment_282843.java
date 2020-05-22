package de.scrum_master.app;

public class Application {
  public static void main(String[] args) {
    Application application = new Application();
    System.out.println(application.validate1());
    System.out.println(application.validate2());
  }

  @MyAnnotation(message = "execute me")
  public boolean validate1() {
    return true;
  }

  @MyAnnotation(message = "msg")
  public boolean validate2() {
    return true;
  }
}
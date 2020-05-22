package de.scrum_master.app;

public class Application {
  public void doSomething() {
    navigateToBookKeys();
  }

  @AccessControl(accessID = "bookKeysViewId")
  private void navigateToBookKeys() {}

  public static void main(String[] args) {
    new Application().doSomething();
  }
}
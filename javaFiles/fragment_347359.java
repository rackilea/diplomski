package de.scrum_master.app;

public class Application {
  public void save(Identity identity) {
    System.out.println("Saving " + identity);
  }

  public static void main(String[] args) {
    Application application = new Application();
    application.save(new Identity<Long>(1L));
    application.save(new Address(2L, 12345, "Germany"));
  }
}
public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ApplicationModule());
    UserService userService = injector.getInstance(UserService.class);
  }
}
public class ServiceUser {
  Service service = new FooService(); // change impl to be used here

  public static void main(String[] args) {
    new ServiceUser().service.useService();
  }
}
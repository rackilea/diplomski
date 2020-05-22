public class Interceptor {
  public void before(@Origin Constructor<?> constructor) {
    System.out.println("before " + constructor.getName());
  }
  public void after(Origin Constructor<?> constructor) {
    System.out.println("after " + constructor.getName());
  }
}
public class Interceptor {
  @RuntimeType
  public static Object intercept(@Origin String method, @AllArguments Object[] args) {
    System.out.println("I have intercepted a call");
    return "Hello";
  }
}
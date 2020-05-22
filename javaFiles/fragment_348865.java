public class GetterInterceptor {

  @RuntimeType
  public static Object intercept(@SuperCall Callable<?> zuper) throws Exception {
    preGetHandle();
    try {
       return zuper.call();
    } finally {
      postGetHandle();
    }
  }

  private static void preGetHandle() {}
  private static void postGetHandle() {}
}
public class Interceptor() {
  public static void intercept(
    @AllArguments Object[] args,
    @FieldValue("name") String name,
    @SuperCall Callable zuper) {
        if (name.equals("BAR"))
           zuper();
        else {/*something else*/}
  }
}
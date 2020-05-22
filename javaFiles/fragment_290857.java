public class Test {
  interface Sub<O> {
    public <I extends Enum<I>> O method(final Class<I> enumType);
  }

  public static <O> O go(final Sub<O> sub) {
    return sub.method(null);
  }
}
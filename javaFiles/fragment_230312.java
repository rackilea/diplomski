public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;

  @IntDef({a, b, c})
  @Retention(RetentionPolicy.SOURCE)
  public @interface SomeIntDef {
  }
@IntDef({a, b, c})
  @Retention(RetentionPolicy.SOURCE)
  public @interface SomeIntDef {
     int a = 0;
     int b = 1;
     int c = 2;
  }
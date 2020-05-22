public Foo(Integer x, Integer y) {
      this(new Integer[]{x, y});
  }

  public Foo(String xy) {
      this(convertStringToIntegers(xy));
  }

  private Foo(Integer[] xy) {
      this.x = xy[0];
      this.y = xy[1];
  }

  private static Integer[] convertStringToIntegers(String xy) {
      Integer[] result;
      //Do what you have to do...
      return result;
  }
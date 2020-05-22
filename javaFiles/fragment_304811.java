public static class Foo<T> implements Comparable<Foo<T>> {

  private T pState;
  private String state;

  @Override
  public int compareTo(Foo<T> other) {
    return 0;
  }
}
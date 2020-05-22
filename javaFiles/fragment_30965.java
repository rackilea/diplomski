public class Foo {
  public static void main(String[] args) {
    File file = new File("/tmp/111");
    Bar bar = mock(Bar.class);
    when(bar.isTrue()).thenReturn(file.mkdir());
  }

  public static interface Bar {
    public boolean isTrue();
  }
}
public class Foo {
  public static void main(String[] args) {
    File file = new File("/tmp/111");
    Bar bar = mock(Bar.class);
    boolean dirMade = file.mkdir();
    when(bar.isTrue()).thenReturn(dirMade);
  }

  public static interface Bar {
    public boolean isTrue();
  }
}
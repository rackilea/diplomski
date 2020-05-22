public class Test {
  public Test();
    Code:
       0: aload_0
       1: invokespecial #1  // Method java/lang/Object."<init>": ()V
       4: getstatic     #2  // Field java/lang/System.out:Ljava/io/PrintStream;
       7: ldc           #3  // String Foo
       9: invokevirtual #4  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      12: return

  public Test(int);
    Code:
       0: aload_0
       1: invokespecial #5                  // Method "<init>":()V
       4: return
}
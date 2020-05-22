public class Test {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override public void run() {
                System.out.println("Hi");
            }
        };
    }
}

> javac Test.java
> dir Test*.class
Test.class
Test$1.class

> javap -c Test$1

Compiled from "Test.java"
final class Test$1 implements java.lang.Runnable {
  Test$1();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void run();
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hi
       5: invokevirtual #4                  // Method java/io/PrintStream.println[...]
       8: return
}
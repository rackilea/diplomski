Compiled from "Test.java"
class Test {
  Test();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]) throws java.lang.NumberFormatException;
    Code:
       0: ldc           #2                  // String 42
       2: astore_1
       3: aload_1
       4: invokestatic  #3                  // Method java/lang/Integer.parseInt:(Ljava/lang/String;)I
       7: istore_2
       8: iload_2
       9: i2d
      10: ldc2_w        #4                  // double 42.0d
      13: dmul
      14: dstore_3
      15: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
      18: dload_3
      19: invokevirtual #7                  // Method java/io/PrintStream.println:(D)V
      22: return
}
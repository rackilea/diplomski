public class Test {
  public Test();
    descriptor: ()V
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]) throws java.lang.Exception;
    descriptor: ([Ljava/lang/String;)V
    Code:
       0: invokedynamic #2,  0              // InvokeDynamic #0:run:()Ljava/lang/Runnable;
       5: astore_1
       6: aload_1
       7: invokeinterface #3,  1            // InterfaceMethod java/lang/Runnable.run:()V
      12: return

  private static void throwException() throws java.io.IOException;
    descriptor: ()V
    Code:
       0: new           #4                  // class java/io/NotSerializableException
       3: dup
       4: invokespecial #5                  // Method java/io/NotSerializableException."<init>":()V
       7: athrow

  private static void lambda$main$0();
    descriptor: ()V
    Code:
       0: invokestatic  #6                  // Method throwException:()V
       3: goto          27
       6: astore_0
       7: getstatic     #9                  // Field java/lang/System.err:Ljava/io/PrintStream;
      10: ldc           #10                 // String wrong
      12: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      15: goto          27
      18: astore_0
      19: getstatic     #9                  // Field java/lang/System.err:Ljava/io/PrintStream;
      22: ldc           #13                 // String right
      24: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      27: return
    Exception table:
       from    to  target type
           0     3     6   Class java/net/SocketException
           0     3     6   Class java/io/EOFException
           0     3    18   Class java/io/IOException
}
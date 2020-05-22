public class stackoverflow.CompilerOptimize {
  public stackoverflow.CompilerOptimize();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: invokestatic  #3                  // Method sayHello:()Ljava/lang/String;
       6: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       9: return

  private static java.lang.String sayHello();
    Code:
       0: ldc           #5                  // String Hello World
       2: areturn

  private static void bananas();
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #6                  // String Monkey!
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
Compiled from "test.java"
class test {
  test();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #2                  // Method doSomething1:()V
       3: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       6: ldc           #4                  // String Now do 2
       8: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      11: invokestatic  #6                  // Method doSomething2:()V
      14: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
      17: ldc           #7                  // String native java
      19: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      22: invokestatic  #8                  // Method doSomethingJava:()V
      25: ldc           #9                  // String test
      27: astore_1      
      28: aload_1       
      29: dup           
      30: astore_2      
      31: monitorenter  
      32: bipush        14
      34: istore_3      
      35: aload_2       
      36: monitorexit   
      37: goto          47
      40: astore        4
      42: aload_2       
      43: monitorexit   
      44: aload         4
      46: athrow        
      47: return        
    Exception table:
       from    to  target type
          32    37    40   any
          40    44    40   any

  public static native void doSomething1();

  public static synchronized native void doSomething2();

  public static synchronized void doSomethingJava();
    Code:
       0: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #10                 // String synchronized
       5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return        
}
Compiled from "Outer.java"
public class com.foo.Outer {
  public int publicField;

  public com.foo.Outer();
    Code:
       0: aload_0       
       1: invokespecial #3                  // Method java/lang/Object."<init>":()V
       4: return        

  public void publicFoo();
    Code:
       0: return        

  static void access$000(com.foo.Outer);
    Code:
       0: aload_0       
       1: invokespecial #2                  // Method privateFoo:()V
       4: return        

  static int access$100(com.foo.Outer);
    Code:
       0: aload_0       
       1: getfield      #1                  // Field privateField:I
       4: ireturn       
}
Compiled from "Outer.java"
class com.foo.Outer$Inner {
  final com.foo.Outer this$0;

  void bar();
    Code:
       0: aload_0       
       1: getfield      #1                  // Field this$0:Lcom/foo/Outer;
       4: invokestatic  #3                  // Method com/foo/Outer.access$000:(Lcom/foo/Outer;)V
       7: aload_0       
       8: getfield      #1                  // Field this$0:Lcom/foo/Outer;
      11: invokevirtual #4                  // Method com/foo/Outer.publicFoo:()V
      14: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      17: new           #6                  // class java/lang/StringBuilder
      20: dup           
      21: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
      24: ldc           #8                  // String privateField = 
      26: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      29: aload_0       
      30: getfield      #1                  // Field this$0:Lcom/foo/Outer;
      33: invokestatic  #10                 // Method com/foo/Outer.access$100:(Lcom/foo/Outer;)I
      36: invokevirtual #11                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      39: invokevirtual #12                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      42: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      45: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      48: new           #6                  // class java/lang/StringBuilder
      51: dup           
      52: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
      55: ldc           #14                 // String publicField = 
      57: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      60: aload_0       
      61: getfield      #1                  // Field this$0:Lcom/foo/Outer;
      64: getfield      #15                 // Field com/foo/Outer.publicField:I
      67: invokevirtual #11                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      70: invokevirtual #12                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      73: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      76: return        
}
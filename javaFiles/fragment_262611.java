Compiled from "CondComp.java"
public class CondComp {
  static final boolean debug;

  public CondComp();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":
()V
       4: return

  public void doIt();
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/
io/PrintStream;
       3: ldc           #3                  // String Here we are
       5: invokevirtual #4                  // Method java/io/PrintStream.printl
n:(Ljava/lang/String;)V
       8: return
}
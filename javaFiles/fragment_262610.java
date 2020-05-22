public class CondComp {
    static final boolean debug = false;
    public void doIt() {
        if (debug) System.out.println("Here we are");
    }
}

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
       0: return
}
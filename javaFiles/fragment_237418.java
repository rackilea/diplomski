Compiled from "CompileSwitch.java"
public class CompileSwitch {
  public CompileSwitch();
    Code:
       0: aload_0
       1: invokespecial #8  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #16 // String C
       2: astore_1
       3: ldc           #18 // String A
       5: aload_1
       6: invokevirtual #20 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
       9: ifne          28
      12: ldc           #26 // String B
      14: aload_1
      15: invokevirtual #20 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      18: ifne          28
      21: ldc           #16 // String C
      23: aload_1
      24: invokevirtual #20 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      27: pop
      28: return
}
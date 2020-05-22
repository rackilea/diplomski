Compiled from "CompileSwitch.java"
public class CompileSwitch {
  public CompileSwitch();
    Code:
       0: aload_0
       1: invokespecial #8 // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #16 // String C
       2: astore_1
       3: aload_1
       4: dup
       5: astore_2
       6: invokevirtual #18 // Method java/lang/String.hashCode:()I
       9: lookupswitch  { // 3
                    65: 44
                    66: 56
                    67: 68
               default: 77
          }
      44: aload_2
      45: ldc           #24 // String A
      47: invokevirtual #26 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      50: ifne          77
      53: goto          77
      56: aload_2
      57: ldc           #30 // String B
      59: invokevirtual #26 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      62: ifne          77
      65: goto          77
      68: aload_2
      69: ldc           #16 // String C
      71: invokevirtual #26 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      74: ifne          77
      77: return
}
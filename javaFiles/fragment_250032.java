C:\Users\Nikolay\workspace\TestNull\bin>javap -c NullTest.class
Compiled from "NullTest.java"
public class NullTest {
  public NullTest();
    Code:
       0: aload_0
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #3                  // class java/lang/Object
       3: dup
       4: invokespecial #8                  // Method java/lang/Object."<init>":()V
       7: astore_1
       8: aconst_null
       9: astore_1
      10: aload_1
      11: invokevirtual #16                 // Method java/lang/Object.notifyAll:()V
      14: return
}
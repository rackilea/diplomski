$ javap -c  OverRidingExample.class 
Compiled from "OverRidingExample.java"
public class org.nagark.OverRidingExample {
  public org.nagark.OverRidingExample();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class org/nagark/baseClass
       3: dup
       4: invokespecial #3                  // Method org/nagark/baseClass."<init>":()V
       7: astore_1
       8: aload_1
       9: iconst_3
      10: invokevirtual #4                  // Method org/nagark/baseClass.callMtd:(I)V
      13: return
}
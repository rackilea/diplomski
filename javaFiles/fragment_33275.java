$ javap -c ../MyClass.class
Compiled from "MyClass.java"
public class MyClass {
  public MyClass();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public MyClass(int);
    Code:
       0: aload_0
       1: invokespecial #2                  // Method "<init>":()V
       4: return
}
Compiled from "test.java"
class ClassB extends ClassA{
ClassB();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method ClassA."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   new #2; //class ClassA
   3:   dup
   4:   invokespecial   #1; //Method ClassA."<init>":()V
   7:   astore_1
   8:   new #3; //class ClassB
   11:  dup
   12:  invokespecial   #4; //Method "<init>":()V
   15:  astore_2
   16:  return

}
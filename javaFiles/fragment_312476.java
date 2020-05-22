Compiled from "Outer.java"
class Outer$1 extends java.lang.Object implements java.lang.Runnable{
final Outer this$0;

Outer$1(Outer);
  Code:
   0:   aload_0
   1:   aload_1
   2:   putfield        #1; //Field this$0:LOuter;
   5:   aload_0
   6:   invokespecial   #2; //Method java/lang/Object."<init>":()V
   9:   return

public void run();
  Code:
   0:   getstatic       #3; //Field java/lang/System.out:Ljava/io/PrintStream;
   3:   ldc     #4; //String hello
   5:   invokevirtual   #5; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   8:   return

}
Compiled from "Clazz.java"
public class Clazz extends java.lang.Object{
java.lang.Object t;

public Clazz();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   aload_0
   5:   new #2; //class java/lang/Object
   8:   dup
   9:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   12:  putfield    #3; //Field t:Ljava/lang/Object;
   15:  return

public static void main(java.lang.String[]);
  Code:
   0:   new #4; //class Clazz
   3:   dup
   4:   invokespecial   #5; //Method "<init>":()V
   7:   astore_1
   8:   aload_1
   9:   getfield    #3; //Field t:Ljava/lang/Object;
//BELOW is the line that will fail
   12:  checkcast   #6; //class java/lang/String
   15:  invokevirtual   #7; //Method java/lang/String.toString:()Ljava/lang/String;
   18:  pop
   19:  return

}
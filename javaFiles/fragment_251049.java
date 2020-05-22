class Test extends java.lang.Object{
Test();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   new         #2; //class A                   
   3:   dup
   4:   invokespecial   #3; //Method A."<init>":()V     
   7:   astore_1
   8:   new         #4; //class B                   
   11:  dup
   12:  aload_1
   13:  invokespecial   #5; //Method B."<init>":(LA;)V  
   16:  astore_2
   17:  new         #4; //class B                  
   20:  dup
   21:  new         #2; //class A                  
   24:  dup
   25:  invokespecial   #3; //Method A."<init>":()V    
   28:  invokespecial   #5; //Method B."<init>":(LA;)V 
   31:  astore_3
   32:  return

}
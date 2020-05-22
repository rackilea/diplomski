enter code here

 HelloWorld();
 Code:
 0:   aload_0
 1:   invokespecial   #1; //Method java/lang/Object."<init>":()
 4:   aload_0
 5:   ldc     #2; //String Hello world!
 7:   putfield        #3; //Field hello:Ljava/lang/String;
 10:  return

 public static void main(java.lang.String[]);
 Code:
 0:   new     #6; //class HelloWorld
 3:   dup
 4:   invokespecial   #7; //Method "<init>":()V
 7:   astore_1
 8:   aload_1
 9:   invokespecial   #8; //Method printHello:()V
12:  return
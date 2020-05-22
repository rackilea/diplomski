public static void test1();
  Code:
   0:   getstatic       #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   3:   new     #3; //class TestLiveness$Square
   6:   dup
   7:   iconst_4
   8:   invokespecial   #4; //Method TestLiveness$Square."<init>":(I)V
   11:  invokevirtual   #5; //Method TestLiveness$Square.square:()I
   14:  invokevirtual   #6; //Method java/io/PrintStream.println:(I)V
   17:  invokestatic    #7; //Method count:()V
   20:  return

public static void test2();
  Code:
   0:   new     #3; //class TestLiveness$Square
   3:   dup
   4:   iconst_4
   5:   invokespecial   #4; //Method TestLiveness$Square."<init>":(I)V
   8:   astore_0
   9:   getstatic       #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   12:  aload_0
   13:  invokevirtual   #5; //Method TestLiveness$Square.square:()I
   16:  invokevirtual   #6; //Method java/io/PrintStream.println:(I)V
   19:  invokestatic    #7; //Method count:()V
   22:  return
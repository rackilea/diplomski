public static void main(java.lang.String[]);
  Code:
   0:   getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   3:   iconst_1 //My Comment: constant with value 1
   4:   invokevirtual   #3; //Method java/io/PrintStream.println:(I)V
   7:   getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   10:  iconst_2 //My Comment: constant with value 2
   11:  invokevirtual   #3; //Method java/io/PrintStream.println:(I)V
   14:  getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   17:  bipush  10 //My Comment: constant with value 10
   19:  invokevirtual   #3; //Method java/io/PrintStream.println:(I)V
   22:  return

}
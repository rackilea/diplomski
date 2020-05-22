public static void main(java.lang.String[]);
  Code:
   0:   new     #3; //class ChangeFinal
   3:   dup
   4:   invokespecial   #11; //Method "<init>":()V
   7:   astore_1
   8:   getstatic       #12; //Field java/lang/System.out:Ljava/io/PrintStream;
   11:  aload_1
   12:  invokevirtual   #13; //Method java/lang/Object.getClass:()Ljava/lang/Cla
ss;
   15:  pop
   16:  bipush  20
   18:  invokevirtual   #14; //Method java/io/PrintStream.println:(I)V
   21:  aload_1
   22:  invokestatic    #15; //Method change:(LChangeFinal;)V
   25:  getstatic       #12; //Field java/lang/System.out:Ljava/io/PrintStream;
   28:  aload_1
   29:  invokevirtual   #13; //Method java/lang/Object.getClass:()Ljava/lang/Cla
ss;
   32:  pop
   33:  bipush  20
   35:  invokevirtual   #14; //Method java/io/PrintStream.println:(I)V
   38:  return

}
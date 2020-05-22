7:   iload_1
   8:   tableswitch{ //1 to 3
                1: 36;
                2: 47;
                3: 58;
                default: 66 }
   36:  getstatic       #3; //Field java/lang/System.out:Ljava/io/PrintStream;
   39:  ldc     #4; //String Cueck
   41:  invokevirtual   #5; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   44:  goto    66
   47:  getstatic       #3; //Field java/lang/System.out:Ljava/io/PrintStream;
   50:  ldc     #6; //String Blub
   52:  invokevirtual   #5; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   55:  goto    66
   58:  getstatic       #3; //Field java/lang/System.out:Ljava/io/PrintStream;
   61:  ldc     #7; //String Writing cases is BORING!
   63:  invokevirtual   #5; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   66:  return
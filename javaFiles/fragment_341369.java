7:   aconst_null
   8:   astore_2
   9:   iload_1
   10:  tableswitch{ //1 to 3
                1: 36;
                2: 42;
                3: 48;
                default: 51 }
   36:  ldc     #3; //String Cueck
   38:  astore_2
   39:  goto    51
   42:  ldc     #4; //String Blub
   44:  astore_2
   45:  goto    51
   48:  ldc     #5; //String Writing cases is BORING!
   50:  astore_2
   51:  getstatic       #6; //Field java/lang/System.out:Ljava/io/PrintStream;
   54:  aload_2
   55:  invokevirtual   #7; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   58:  return
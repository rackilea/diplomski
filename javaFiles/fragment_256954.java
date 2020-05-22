Test();
  Code:
    0:  aload_0
    1:  invokespecial
    4:  getstatic #2;
    7:  ldc #3;           //String "Initializer block"
    9:  invokevirtual #4; //Method PrintStream.println:(String;)V
   12:  getstatic #2;
   15:  ldc #5;
   17:  invokevirtual #4;
   20:  return

Test(int);
  Code:
    0:  aload_0
    1:  invokespecial #1;
    4:  getstatic #2;
    7:  ldc #3;           //String "Initializer block"
    9:  invokevirtual #4; //Method PrintStream.println:(String;)V
   12:  getstatic #2;
   15:  ldc #6;
   17:  invokevirtual #4;
   20:  return
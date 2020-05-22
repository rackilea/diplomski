void test1();
    Code:
       0: getstatic     #15                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #21                 // String hello
       5: invokevirtual #23                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: goto          0

  void test2();
    Code:
       0: getstatic     #15                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #31                 // String world
       5: invokevirtual #23                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: goto          0
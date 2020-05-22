public com.stackoverflow.Demo();
    Code:
       0: aload_0
       1: invokespecial #12                 // Method java/lang/Object."<init>":()V
       4: return

  void test1();
    Code:
       0: ldc           #8                  // String A
       2: astore_1
       3: return

  void test2();
    Code:
       0: ldc           #8                  // String A
       2: astore_1
       3: return

  void test3();
    Code:
       0: getstatic     #22                 // Field Test.A:LTest;
       3: invokevirtual #27                 // Method Test.getTestCode:()Ljava/lang/String;
       6: astore_1
       7: return
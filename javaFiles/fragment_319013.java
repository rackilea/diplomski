public Main();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         7: aload_0
         8: getfield      #3                  // Field x:I
        11: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
        14: aload_0
        15: iconst_1
        16: putfield      #3                  // Field x:I
        19: return
      LineNumberTable:
        line 1: 0
        line 7: 4
        line 9: 14
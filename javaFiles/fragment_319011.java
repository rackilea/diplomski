public MainC();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: iconst_1
         6: putfield      #2                  // Field x:I
         9: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
        12: aload_0
        13: getfield      #2                  // Field x:I
        16: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
        19: return
      LineNumberTable:
        line 1: 0
        line 7: 4
        line 9: 9
        line 10: 19
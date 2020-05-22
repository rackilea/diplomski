static void evenOrOdd(int);
descriptor: (I)V
flags: ACC_STATIC
Code:
  stack=3, locals=1, args_size=1
     0: getstatic     #2        // Field java/lang/System.out:Ljava/io/PrintStream;
     3: iload_0
     4: iconst_1
     5: iand
     6: ifeq          14
     9: ldc           #3        // String odd
    11: goto          16
    14: ldc           #4        // String even
    16: invokevirtual #5        // Method java/io/PrintStream.println:(Ljava/lang/String;)V
    19: return
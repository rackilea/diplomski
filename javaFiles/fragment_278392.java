public static void main(java.lang.String...);
    Code:
       0: new           #2                  // class A$B
       3: dup
       4: invokespecial #3                  // Method A$B."<init>":()V
       7: astore_1
       8: aload_1
       9: instanceof    #2                  // class A$B
      12: ifeq          25
      15: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
      18: aload_1
      19: checkcast     #2                  // class A$B
      22: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      25: return
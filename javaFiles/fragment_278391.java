public static void main(java.lang.String...);
    Code:
       0: new           #2                  // class A$B
       3: dup
       4: invokespecial #3                  // Method A$B."<init>":()V
       7: astore_1
       8: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
      11: aload_1
      12: checkcast     #2                  // class A$B
      15: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      18: return
}
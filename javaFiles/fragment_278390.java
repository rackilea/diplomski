public static void main(java.lang.String...);
    Code:
       0: ldc           #2                  // String a
       2: astore_1
       3: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       6: aload_1
       7: checkcast     #4                  // class java/lang/String
      10: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      13: return
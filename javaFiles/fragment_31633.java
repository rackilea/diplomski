public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #2        // Method Test.f:()LTuple;
       3: astore_1
       4: getstatic     #3        // Field java/lang/System.out:Ljava/io/PrintStream;
       7: aload_1
       8: getfield      #4        // Field Tuple.second:Ljava/lang/Object;
      11: checkcast     #5        // class Bar
      14: invokevirtual #6        // Method java/lang/Object.getClass:()Ljava/lang/Class;
      17: invokevirtual #7        // Method java/lang/Class.getSimpleName:()Ljava/lang/String;
      20: invokevirtual #8        // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      23: return
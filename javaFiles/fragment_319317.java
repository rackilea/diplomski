public java.lang.Object invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]) throws java.lang.Throwable;
Code:
   0: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
   3: ldc           #4                  // String Java handler works
   5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
   8: aload_2
   9: aload_0
  10: getfield      #2                  // Field target:LIface;
  13: aload_3
  14: invokevirtual #6                  // Method java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
  17: areturn
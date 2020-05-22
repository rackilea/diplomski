public java.lang.Object invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]);
Code:
   0: aload_2
   1: ldc           #12                 // String method
   3: invokestatic  #18                 // Method kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
   6: ldc           #20                 // String Kotlin proxy works
   8: astore        4
  10: getstatic     #26                 // Field java/lang/System.out:Ljava/io/PrintStream;
  13: aload         4
  15: invokevirtual #32                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
  18: aload_2
  19: aload_0
  20: getfield      #36                 // Field target:LIface;
  23: iconst_1
  24: anewarray     #4                  // class java/lang/Object
  27: dup
  28: iconst_0
  29: aload_3
  30: aastore
  31: invokevirtual #41                 // Method java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
  34: areturn
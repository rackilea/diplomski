static boolean z(java.lang.String);
    Code:
       0: aload_0       
       1: ifnull        15
       4: aload_0       
       5: ldc           #16                 // String Foo
       7: invokevirtual #21                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      10: ifeq          15
      13: iconst_1      
      14: ireturn       
      15: iconst_0      
      16: ireturn
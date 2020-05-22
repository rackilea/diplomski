public static <T extends java.lang.Throwable> java.lang.RuntimeException sneakyThrow(java.lang.Throwable) throws T;
  descriptor: (Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
  flags: ACC_PUBLIC, ACC_STATIC
  Code:
    stack=1, locals=1, args_size=1
       0: aload_0
       1: athrow
  Exceptions:
    throws java.lang.Throwable
  Signature: #13                          // <T:Ljava/lang/Throwable;>(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;^TT;
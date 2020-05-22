0: aconst_null
     1: astore_0
     2: aconst_null
     3: astore_1
     4: invokestatic  #18        // Method dummy:()Ljava/lang/AutoCloseable;
     7: astore_2
     8: invokestatic  #22        // Method bar:()V
    11: aload_2
    12: ifnull        59
    15: aload_2
    16: invokeinterface #25,  1  // InterfaceMethod java/lang/AutoCloseable.close:()V
    21: goto          59
    24: astore_0
    25: aload_2
    26: ifnull        35
    29: aload_2
    30: invokeinterface #25,  1  // InterfaceMethod java/lang/AutoCloseable.close:()V
    35: aload_0
    36: athrow
    37: astore_1
    38: aload_0
    39: ifnonnull     47
    42: aload_1
    43: astore_0
    44: goto          57
    47: aload_0
    48: aload_1
    49: if_acmpeq     57
    52: aload_0
    53: aload_1
    54: invokevirtual #30        // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
    57: aload_0
    58: athrow
    59: return
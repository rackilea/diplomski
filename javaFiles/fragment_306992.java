Code:
   0: invokestatic  #2        // Method dummy:()Ljava/lang/AutoCloseable;
   3: astore_0
   4: invokestatic  #3        // Method bar:()V
   7: aload_0
   8: ifnull        42
  11: aload_0
  12: invokeinterface #4,  1  // InterfaceMethod java/lang/AutoCloseable.close:()V
  17: goto          42
  20: astore_1
  21: aload_0
  22: ifnull        40
  25: aload_0
  26: invokeinterface #4,  1  // InterfaceMethod java/lang/AutoCloseable.close:()V
  31: goto          40
  34: astore_2
  35: aload_1
  36: aload_2
  37: invokevirtual #6        // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
  40: aload_1
  41: athrow
  42: return
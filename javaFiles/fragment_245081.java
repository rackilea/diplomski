public static final Comparator<Integer> COMPARATOR;    

  public static Comparator<Integer> reference();
      0: getstatic     #2  // Field COMPARATOR:LComparator;    
      3: dup    
      4: invokevirtual #3   // Method Object.getClass:()LClass;    
      7: pop    
      8: invokedynamic #4,  0  // InvokeDynamic #0:compare:(LComparator;)LComparator;    
      13: checkcast     #5  // class Serializable    
      16: checkcast     #6  // class Comparator    
      19: areturn

  public static Comparator<Integer> explicit();
      0: invokedynamic #7,  0  // InvokeDynamic #1:compare:()LComparator;    
      5: checkcast     #5  // class Serializable    
      8: checkcast     #6  // class Comparator    
      11: areturn

  private static int lambda$explicit$d34e1a25$1(Integer, Integer);
     0: getstatic     #2  // Field COMPARATOR:LComparator;
     3: aload_0
     4: aload_1
     5: invokeinterface #44,  3  // InterfaceMethod Comparator.compare:(LObject;LObject;)I
    10: ireturn

BootstrapMethods:    
  0: #61 invokestatic invoke/LambdaMetafactory.altMetafactory:(Linvoke/MethodHandles$Lookup;LString;Linvoke/MethodType;[LObject;)Linvoke/CallSite;    
    Method arguments:    
      #62 (LObject;LObject;)I    
      #63 invokeinterface Comparator.compare:(LObject;LObject;)I    
      #64 (LInteger;LInteger;)I    
      #65 5    
      #66 0    

  1: #61 invokestatic invoke/LambdaMetafactory.altMetafactory:(Linvoke/MethodHandles$Lookup;LString;Linvoke/MethodType;[LObject;)Linvoke/CallSite;    
    Method arguments:    
      #62 (LObject;LObject;)I    
      #70 invokestatic Generic.lambda$explicit$df5d232f$1:(LInteger;LInteger;)I    
      #64 (LInteger;LInteger;)I    
      #65 5    
      #66 0
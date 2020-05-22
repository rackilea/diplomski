public static Comparator<Integer> reference();
      0: getstatic     #2  // Field COMPARATOR:LComparator;    
      3: dup    
      4: invokevirtual #3   // Method Object.getClass:()LClass;    
      7: pop    
      8: invokedynamic #4,  0  // InvokeDynamic #0:compare:(LComparator;)LComparator;    
      13: checkcast     #5  // class java/io/Serializable    
      16: checkcast     #6  // class Comparator    
      19: areturn
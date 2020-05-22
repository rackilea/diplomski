public void iterate(java.util.List<java.lang.String>);
    Code:
       0: new           #2                  // class java/util/TreeSet
       3: dup
       4: invokedynamic #3,  0              // InvokeDynamic #0:compare:()Ljava/util/Comparator;
       9: invokespecial #4                  // Method java/util/TreeSet."<init>":(Ljava/util/Comparator;)V
      12: astore_2
      13: return
public java.lang.String toString();
    Code:
       0: aload_0
       1: getfield      #2                  // Field isMinHeap:Z
       4: ifeq          10
       7: ldc           #3                  // String Min!
       9: areturn
      10: ldc           #4                  // String Not Min
      12: areturn
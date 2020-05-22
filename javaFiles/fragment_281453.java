public void read();
    Code:
       0: aload_0
       1: getfield      #3                  // Field lock:Ljava/lang/Object;
       4: dup
       5: astore_1
       6: monitorenter
       7: aload_1
       8: monitorexit
       9: goto          17
      12: astore_2
      13: aload_1
      14: monitorexit
      15: aload_2
      16: athrow
      17: return
    Exception table:
       from    to  target type
           7     9    12   any
          12    15    12   any
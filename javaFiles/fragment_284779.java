Code:
  stack=3, locals=5, args_size=1
     0: ldc           #2                  // String a
     2: astore_1
     3: ldc           #3                  // String bb
     5: astore_2
     6: ldc           #4                  // String ccc
     8: astore_3
     9: aload_1
    10: aload_2
    11: aload_3
    12: invokedynamic #5,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    17: astore        4
    19: return
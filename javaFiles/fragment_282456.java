private static java.lang.Integer lambda$main$0(java.lang.Integer);
descriptor: (Ljava/lang/Integer;)Ljava/lang/Integer;
flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
Code:
  stack=3, locals=1, args_size=1
     0: aload_0
     1: invokevirtual #7                  // Method java/lang/Integer.intValue:()I
     4: aload_0
     5: invokevirtual #7                  // Method java/lang/Integer.intValue:()I
     8: imul
     9: iconst_2
    10: aload_0
    11: invokevirtual #7                  // Method java/lang/Integer.intValue:()I
    14: imul
    15: iadd
    16: iconst_1
    17: iadd
    18: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
    21: areturn
  LineNumberTable:
    line 4: 0
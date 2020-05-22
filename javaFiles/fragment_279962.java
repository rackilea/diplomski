0: iconst_1
   1: istore_1
   2: iconst_2
   3: istore_2
   4: iload_1
   5: iload_2
   6: iadd
   7: istore_3
   8: iload_3
   9: iconst_2
  10: iadd
  11: istore        4
  13: iload_1
  14: iload         4
  16: iadd
  17: iload_3
  18: iadd
  19: istore        5
  21: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
  24: iload         5
  26: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
  29: return
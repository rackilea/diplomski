public static void main(java.lang.String[]);
   Code:
      0: iconst_5
      1: istore_1
      2: iload_1
      3: iconst_1
      4: iadd
      5: istore_1
      6: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      9: iload_1
     10: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     13: iinc          1, 1
     16: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     19: iload_1
     20: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     23: return
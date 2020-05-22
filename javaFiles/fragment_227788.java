public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: bipush        10
       5: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
       8: iconst_0
       9: istore_1
      10: iload_1
      11: bipush        100
      13: if_icmpge     29
      16: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      19: iload_1
      20: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
      23: iinc          1, 1
      26: goto          10
      29: return
    LineNumberTable:
      line 3: 0
      line 5: 8
      line 6: 10
      line 8: 16
      line 7: 23
      line 9: 29
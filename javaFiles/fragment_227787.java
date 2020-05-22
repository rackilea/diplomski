public static void main(java.lang.String[]);
    Code:
       0: getstatic     #16                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: bipush        10
       5: invokevirtual #22                 // Method java/io/PrintStream.println:(I)V
       8: iconst_0
       9: istore_1
      10: goto          23
      13: getstatic     #16                 // Field java/lang/System.out:Ljava/io/PrintStream;
      16: iload_1
      17: invokevirtual #22                 // Method java/io/PrintStream.println:(I)V
      20: iinc          1, 1
      23: iload_1
      24: bipush        100
      26: if_icmplt     13               // HERE
      29: return
    LineNumberTable:
      line 3: 0
      line 5: 8
      line 6: 10
      line 8: 13
      line 7: 20
      line 6: 23
      line 4: 26                         /* 02 */ in your code
      line 9: 29
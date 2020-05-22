//  first variant            second variant
  0: iconst_1              0: iconst_1
  1: istore_1              1: istore_1
  2: iload_1               2: iload_1
  3: bipush        10      3: bipush        10
  5: if_icmpge     33      5: if_icmpge     40
  8: iload_1               8: iload_1
  9: iconst_2              9: iconst_2
 10: irem                 10: irem
 11: ifne          27     11: ifne          34
                          14: getstatic     #2    // Field java/lang/System.out:Ljava/io/PrintStream;
                          17: iload_1
                          18: invokevirtual #3    // Method java/io/PrintStream.print:(I)V
 14: iload_1              21: iload_1
 15: iconst_3             22: iconst_3
 16: irem                 23: irem
 17: ifne          27     24: ifne          34
 20: getstatic     #2     27: getstatic     #2    // Field java/lang/System.out:Ljava/io/PrintStream;
 23: iload_1              30: iload_1
 24: invokevirtual #3     31: invokevirtual #3    // Method java/io/PrintStream.print:(I)V
 27: iinc          1, 1   34: iinc          1, 1
 30: goto          2      37: goto          2
 33: return               40: return
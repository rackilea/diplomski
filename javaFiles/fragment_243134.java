// method 1; if(a>5)
  13: iload_1
  14: iconst_5
  15: if_icmple     25
  18: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
  21: iconst_1
  22: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
// method 2; if(a>NUM1)
  25: iload_1
  26: iconst_5
  27: if_icmple     37
  30: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
  33: iconst_2
  34: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
// method 3; if(a > 6+b)
  37: iload_1
  38: bipush        6
  40: iload_2
  41: iadd
  42: if_icmple     52
  45: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
  48: iconst_1
  49: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
// method 4; if(a > 6+b)
  52: iload_1
  53: bipush        6
  55: iload_2
  56: iadd
  57: if_icmple     67
  60: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
  63: iconst_1
  64: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
  67: return
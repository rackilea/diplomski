static boolean isOddAndShort(int);
descriptor: (I)Z
flags: ACC_STATIC
Code:
  stack=2, locals=1, args_size=1
     0: iload_0
     1: iconst_1
     2: iand
     3: ifeq          17
     6: iload_0
     7: bipush        16
     9: iushr
    10: ifne          17
    13: iconst_1
    14: goto          18
    17: iconst_0
    18: ireturn
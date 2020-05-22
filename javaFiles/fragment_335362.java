public static int boolToInt(boolean);
   Code:
     0: iload_0
     1: ifeq          8     //conditional here
     4: iconst_1
     5: goto          9
     8: iconst_0
     9: ireturn
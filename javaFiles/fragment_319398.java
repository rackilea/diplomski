public static char two(java.lang.String);
Code:
   0: aload_0
   1: astore_1
   2: iconst_m1
   3: istore_2
   4: aload_1
   5: invokevirtual #9                  // Method java/lang/String.hashCode:()I
   8: lookupswitch  { // 2
                97: 36
                98: 50
           default: 61
      }
  36: aload_1
  37: ldc           #10                 // String a
  39: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  42: ifeq          61
  45: iconst_0
  46: istore_2
  47: goto          61
  50: aload_1
  51: ldc           #12                 // String b
  53: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  56: ifeq          61
  59: iconst_1
  60: istore_2
  61: iload_2
  62: lookupswitch  { // 2
                 0: 88
                 1: 91
           default: 94
      }
  88: bipush        97
  90: ireturn
  91: bipush        98
  93: ireturn
  94: iconst_0
  95: ireturn
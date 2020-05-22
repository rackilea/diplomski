public static char three(java.lang.String);
Code:
   0: aload_0
   1: astore_1
   2: iconst_m1
   3: istore_2
   4: aload_1
   5: invokevirtual #9                  // Method java/lang/String.hashCode:()I
   8: lookupswitch  { // 3
                 0: 72
                97: 44
                98: 58
           default: 83
      }
  44: aload_1
  45: ldc           #10                 // String a
  47: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  50: ifeq          83
  53: iconst_0
  54: istore_2
  55: goto          83
  58: aload_1
  59: ldc           #12                 // String b
  61: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  64: ifeq          83
  67: iconst_1
  68: istore_2
  69: goto          83
  72: aload_1
  73: ldc           #13                 // String
  75: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  78: ifeq          83
  81: iconst_2
  82: istore_2
  83: iload_2
  84: tableswitch   { // 0 to 2
                 0: 112
                 1: 115
                 2: 118
           default: 120
      }
 112: bipush        97
 114: ireturn
 115: bipush        98
 117: ireturn
 118: iconst_0
 119: ireturn
 120: iconst_0
 121: ireturn
public static char three(java.lang.String);
Code:
   0: aload_0
   1: astore_1
   2: iconst_m1
   3: istore_2
   4: aload_1
   5: invokevirtual #9                  // Method java/lang/String.hashCode:()I
   8: tableswitch   { // 97 to 99
                97: 36
                98: 50
                99: 64
           default: 75
      }
  36: aload_1
  37: ldc           #10                 // String a
  39: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  42: ifeq          75
  45: iconst_0
  46: istore_2
  47: goto          75
  50: aload_1
  51: ldc           #12                 // String b
  53: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  56: ifeq          75
  59: iconst_1
  60: istore_2
  61: goto          75
  64: aload_1
  65: ldc           #13                 // String c
  67: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  70: ifeq          75
  73: iconst_2
  74: istore_2
  75: iload_2
  76: tableswitch   { // 0 to 2
                 0: 104
                 1: 107
                 2: 110
           default: 113
      }
 104: bipush        97
 106: ireturn
 107: bipush        98
 109: ireturn
 110: bipush        99
 112: ireturn
 113: iconst_0
 114: ireturn
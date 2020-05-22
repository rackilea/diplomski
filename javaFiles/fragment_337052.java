public static void main(java.lang.String[]);
  descriptor: ([Ljava/lang/String;)V
  flags: ACC_PUBLIC, ACC_STATIC
Code:
  stack=2, locals=2, args_size=1
     0: iconst_0
     1: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     4: astore_1
     5: aload_1
     6: invokevirtual #3                  // Method java/lang/Integer.intValue:()I
     9: bipush        100
    11: if_icmpge     34
    14: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
    17: aload_1
    18: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
    21: aload_1
    22: invokevirtual #3                  // Method java/lang/Integer.intValue:()I
    25: iconst_1
    26: iadd
    27: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
    30: astore_1
    31: goto          5
    34: return
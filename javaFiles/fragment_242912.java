public static void main(java.lang.String[]);
  Code:
   0: bipush        10
   2: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   5: astore_1      
   6: bipush        10
   8: istore_2      
   9: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
  12: aload_1       
  13: bipush        10
  15: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
  18: if_acmpne     25
  21: iconst_1      
  22: goto          26
  25: iconst_0      
  26: invokevirtual #4                  // Method java/io/PrintStream.println:(Z)V
  29: return
public static void main(java.lang.String[]);
  Code:
   0: new           #2                  // class java/lang/Integer
   3: dup           
   4: bipush        10
   6: invokespecial #3                  // Method java/lang/Integer."<init>":(I)V
   9: astore_1      
  10: aload_1       
  11: invokestatic  #4                  // Method compare:(Ljava/lang/Number;)V
  14: return        

public static void compare(java.lang.Number);
  Code:
   0: bipush        10
   2: istore_1      
   3: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
   6: aload_0       
   7: bipush        10
   9: invokestatic  #6                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
  12: if_acmpne     19
  15: iconst_1      
  16: goto          20
  19: iconst_0      
  20: invokevirtual #7                  // Method java/io/PrintStream.println:(Z)V
  23: return
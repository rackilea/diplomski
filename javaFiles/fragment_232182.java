public static void main(java.lang.String[]);
    Code:
       0: ldc           #16                 // String This is 
       2: astore_1      
       3: ldc           #18                 // String my book
       5: astore_2      
       6: ldc           #20                 // String This is my book
       8: astore_3      
       9: ldc           #20                 // String This is my book
      11: astore        4
      13: getstatic     #22                 // Field java/lang/System.out:Ljava/io/PrintStream;
      16: aload_3       
      17: aload         4
      19: if_acmpne     26
      22: iconst_1      
      23: goto          27
      26: iconst_0      
      27: invokevirtual #28                 // Method java/io/PrintStream.println:(Z)V
      30: return
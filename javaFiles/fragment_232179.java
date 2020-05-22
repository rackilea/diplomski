public static void main(java.lang.String[]);
    Code:
       0: ldc           #16                 // String This is 
       2: astore_1      
       3: new           #18                 // class java/lang/StringBuilder
       6: dup           
       7: aload_1       
       8: invokestatic  #20                 // Method java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
      11: invokespecial #26                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
      14: ldc           #29                 // String my book
      16: invokevirtual #31                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: invokevirtual #35                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      22: astore_1      
      23: ldc           #39                 // String This is my book
      25: astore_2      
      26: getstatic     #41                 // Field java/lang/System.out:Ljava/io/PrintStream;
      29: aload_1       
      30: aload_2       
      31: if_acmpne     38
      34: iconst_1      
      35: goto          39
      38: iconst_0      
      39: invokevirtual #47                 // Method java/io/PrintStream.println:(Z)V
      42: return
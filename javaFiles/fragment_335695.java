public static boolean checkRegex(java.lang.String, java.lang.String);
    Code:
       0: aload_1       
       1: ifnonnull     6
       4: iconst_0      
       5: ireturn       
       6: aload_0       
       7: invokestatic  #15                 // Method java/util/regex/Pattern.compile:(Ljava/lang/String;)Ljava/util/regex/Pattern;
      10: astore_2      
      11: aload_2       
      12: aload_1       
      13: invokevirtual #16                 // Method java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      16: astore_3      
      17: aload_3       
      18: invokevirtual #17                 // Method java/util/regex/Matcher.matches:()Z
      21: ireturn       

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #18                 // String ^.+@.+\..+$
       2: ldc           #19                 // String email@example.com
       4: invokestatic  #20                 // Method checkRegex:(Ljava/lang/String;Ljava/lang/String;)Z
       7: pop
       ...
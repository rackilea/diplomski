public static void main(java.lang.String[]);
  Code:
     0: ldc           #2                  // String a
     2: astore_1      
     3: ldc           #3                  // String b
     5: astore_2      
     6: ldc           #4                  // String c
     8: astore_3      
     9: new           #5                  // class java/lang/StringBuilder
    12: dup           
    13: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
    16: aload_1       
    17: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    20: aload_2       
    21: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    24: aload_3       
    25: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    28: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
    31: astore        4
  33: return
0: ldc           #2      // int 50103
 2: invokestatic  #3      // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 5: astore_1
 6: ldc           #4      // int 40122
 8: invokestatic  #3      // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
11: astore_2
12: aload_1
13: invokevirtual #5      // Method java/lang/Integer.intValue:()I
16: aload_2
17: invokevirtual #5      // Method java/lang/Integer.intValue:()I
20: isub
21: istore_3
22: getstatic     #6      // Field java/lang/System.out:Ljava/io/PrintStream;
25: iload_3
26: invokevirtual #7      // Method java/io/PrintStream.println:(I)V
29: return
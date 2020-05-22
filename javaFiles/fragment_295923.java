stack=3, locals=6, args_size=1
     0: new           #2                  // class java/util/zip/GZIPOutputStream
     3: dup           
     4: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     7: invokespecial #4                  // Method java/util/zip/GZIPOutputStream."<init>":(Ljava/io/OutputStream;)V
    10: astore_1      
    11: aconst_null   
    12: astore_2      
    13: aload_1       
    14: ldc           #5                  // String TEST
    16: ldc           #6                  // String UTF-8
    18: invokevirtual #7                  // Method java/lang/String.getBytes:(Ljava/lang/String;)[B
    21: invokevirtual #8                  // Method java/util/zip/GZIPOutputStream.write:([B)V
    24: aload_1       
    25: ifnull        95
    28: aload_2       
    29: ifnull        48
    32: aload_1       
    33: invokevirtual #9                  // Method java/util/zip/GZIPOutputStream.close:()V
    36: goto          95
    39: astore_3      
    40: aload_2       
    41: aload_3       
    42: invokevirtual #11                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
    45: goto          95
    48: aload_1       
    49: invokevirtual #9                  // Method java/util/zip/GZIPOutputStream.close:()V
    52: goto          95
    55: astore_3      
    56: aload_3       
    57: astore_2      
    58: aload_3       
    59: athrow        
    60: astore        4
    62: aload_1       
    63: ifnull        92
    66: aload_2       
    67: ifnull        88
    70: aload_1       
    71: invokevirtual #9                  // Method java/util/zip/GZIPOutputStream.close:()V
    74: goto          92
    77: astore        5
    79: aload_2       
    80: aload         5
    82: invokevirtual #11                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
    85: goto          92
    88: aload_1       
    89: invokevirtual #9                  // Method java/util/zip/GZIPOutputStream.close:()V
    92: aload         4
    94: athrow        
    95: goto          103
    98: astore_1      
    99: aload_1       
   100: invokevirtual #13                 // Method java/io/IOException.printStackTrace:()V
   103: return        
  Exception table:
     from    to  target type
        32    36    39   Class java/lang/Throwable
        13    24    55   Class java/lang/Throwable
        13    24    60   any
        70    74    77   Class java/lang/Throwable
        55    62    60   any
         0    95    98   Class java/io/IOException
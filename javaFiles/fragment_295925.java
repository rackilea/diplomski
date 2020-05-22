stack=3, locals=10, args_size=1
     0: new           #2                  // class java/io/ByteArrayOutputStream
     3: dup           
     4: invokespecial #3                  // Method java/io/ByteArrayOutputStream."<init>":()V
     7: astore_1      
     8: aconst_null   
     9: astore_2      
    10: new           #4                  // class java/util/zip/GZIPOutputStream
    13: dup           
    14: aload_1       
    15: invokespecial #5                  // Method java/util/zip/GZIPOutputStream."<init>":(Ljava/io/OutputStream;)V
    18: astore_3      
    19: aconst_null   
    20: astore        4
    22: aload_3       
    23: ldc           #6                  // String TEST
    25: ldc           #7                  // String UTF-8
    27: invokevirtual #8                  // Method java/lang/String.getBytes:(Ljava/lang/String;)[B
    30: invokevirtual #9                  // Method java/util/zip/GZIPOutputStream.write:([B)V
    33: aload_3       
    34: ifnull        114
    37: aload         4
    39: ifnull        61
    42: aload_3       
    43: invokevirtual #10                 // Method java/util/zip/GZIPOutputStream.close:()V
    46: goto          114
    49: astore        5
    51: aload         4
    53: aload         5
    55: invokevirtual #12                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
    58: goto          114
    61: aload_3       
    62: invokevirtual #10                 // Method java/util/zip/GZIPOutputStream.close:()V
    65: goto          114
    68: astore        5
    70: aload         5
    72: astore        4
    74: aload         5
    76: athrow        
    77: astore        6
    79: aload_3       
    80: ifnull        111
    83: aload         4
    85: ifnull        107
    88: aload_3       
    89: invokevirtual #10                 // Method java/util/zip/GZIPOutputStream.close:()V
    92: goto          111
    95: astore        7
    97: aload         4
    99: aload         7
   101: invokevirtual #12                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
   104: goto          111
   107: aload_3       
   108: invokevirtual #10                 // Method java/util/zip/GZIPOutputStream.close:()V
   111: aload         6
   113: athrow        
   114: aload_1       
   115: ifnull        185
   118: aload_2       
   119: ifnull        138
   122: aload_1       
   123: invokevirtual #13                 // Method java/io/ByteArrayOutputStream.close:()V
   126: goto          185
   129: astore_3      
   130: aload_2       
   131: aload_3       
   132: invokevirtual #12                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
   135: goto          185
   138: aload_1       
   139: invokevirtual #13                 // Method java/io/ByteArrayOutputStream.close:()V
   142: goto          185
   145: astore_3      
   146: aload_3       
   147: astore_2      
   148: aload_3       
   149: athrow        
   150: astore        8
   152: aload_1       
   153: ifnull        182
   156: aload_2       
   157: ifnull        178
   160: aload_1       
   161: invokevirtual #13                 // Method java/io/ByteArrayOutputStream.close:()V
   164: goto          182
   167: astore        9
   169: aload_2       
   170: aload         9
   172: invokevirtual #12                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
   175: goto          182
   178: aload_1       
   179: invokevirtual #13                 // Method java/io/ByteArrayOutputStream.close:()V
   182: aload         8
   184: athrow        
   185: goto          193
   188: astore_1      
   189: aload_1       
   190: invokevirtual #15                 // Method java/io/IOException.printStackTrace:()V
   193: return        
  Exception table:
     from    to  target type
        42    46    49   Class java/lang/Throwable
        22    33    68   Class java/lang/Throwable
        22    33    77   any
        88    92    95   Class java/lang/Throwable
        68    79    77   any
       122   126   129   Class java/lang/Throwable
        10   114   145   Class java/lang/Throwable
        10   114   150   any
       160   164   167   Class java/lang/Throwable
       145   152   150   any
         0   185   188   Class java/io/IOException
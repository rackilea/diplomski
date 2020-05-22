public static void main(java.lang.String[] args);
    0  ldc <String "abc"> [16]
    2  astore_1 [str]
    3  new java.lang.StringBuilder [18]
    6  dup
    7  ldc <String "foo"> [20]
    9  invokespecial java.lang.StringBuilder(java.lang.String) [22]
   12  aload_1 [str]
   13  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [25]
   16  ldc <String "bar"> [29]
   18  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [25]
   21  aload_1 [str]
   22  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [25]
   25  invokevirtual java.lang.StringBuilder.toString() : java.lang.String [31]
   28  astore_2 [str2]
   29  getstatic java.lang.System.out : java.io.PrintStream [35]
   32  aload_2 [str2]
   33  invokevirtual java.io.PrintStream.println(java.lang.String) : void [41]
   36  return
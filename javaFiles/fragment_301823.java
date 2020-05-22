public int ifelsemethod();
 0  aload_0 [this]
 1  iconst_1
 2  putfield ifperf.main.x : int [22]
 5  aload_0 [this]
 6  getfield ifperf.main.x : int [22]
 9  ifne 23
12  getstatic java.lang.System.out : java.io.PrintStream [24]
15  ldc <String "something"> [30]
17  invokevirtual java.io.PrintStream.println(java.lang.String) : void [32]
20  goto 25
23  iconst_1
24  ireturn
25  bipush 7
27  ireturn
public int ifmethod();
 0  aload_0 [this]
 1  iconst_1
 2  putfield ifperf.main.x : int [22]
 5  aload_0 [this]
 6  getfield ifperf.main.x : int [22]
 9  ifne 20
12  getstatic java.lang.System.out : java.io.PrintStream [24]
15  ldc <String "something"> [30]
17  invokevirtual java.io.PrintStream.println(java.lang.String) : void [32]
20  iconst_1
21  ireturn
--- Compress.java.orig  2011-03-25 16:57:47.000000000 -0700
+++ Compress.java   2011-03-25 17:09:42.000000000 -0700
@@ -1,12 +1,12 @@
-import java.util.*
+import java.util.*;

 public class Compress {

 static char START_A = "A".charAt(0);
 static char START_a = "a".charAt(0);
 static char START_0 = "0".charAt(0);
-static int CODEMASK = ((1 << 28) - 1); //turn on lower 28 bits
-static int RANDOMMASK = ((1 << 60) - 1) & ~ CODEMASK; //turn on upper 32 bits
+static long CODEMASK = ((1 << 28) - 1); //turn on lower 28 bits
+static long RANDOMMASK = ((1L << 60) - 1) & ~ CODEMASK; //turn on upper 32 bits

 public static void main(String[] args) {

@@ -42,10 +42,10 @@
     char a = line.charAt(0);
     char b = line.charAt(1);
     char c = line.charAt(2);
-    char h = line.charAt(3);
-    char i = line.charAt(4);
-    char j = line.charAt(5);
-    char k = line.charAt(6);
+    int h = line.charAt(3) - START_0;
+    int i = line.charAt(4) - START_0;
+    int j = line.charAt(5) - START_0;
+    int k = line.charAt(6) - START_0;

     long small_a = (long) a - START_A;
     long small_b = (long) b - START_A;
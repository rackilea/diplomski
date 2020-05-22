Index: app/build.gradle
===================================================================
--- app/build.gradle    (revision 9d9c3ce4e0f903b5e7c650f231577c20585e6923)
+++ app/build.gradle    (revision )
@@ -2,8 +2,7 @@

 dependencies {
     // aspectJ compiler
-    compile 'org.aspectj:aspectjrt:1.8.1'
-
+    compile 'org.aspectj:aspectjrt:1.8.4'
     compile (project (':annotation'))
 }

@@ -50,13 +49,13 @@
     JavaCompile javaCompile = variant.javaCompile
     javaCompile.doLast {
         String[] args = ["-showWeaveInfo",
-                         "-1.5",
+                         "-1.7",
                          "-XnoInline",
                          "-inpath", javaCompile.destinationDir.toString(),
                          "-aspectpath", javaCompile.classpath.asPath,
                          "-d", javaCompile.destinationDir.toString(),
                          "-classpath", javaCompile.classpath.asPath,
-                         //"-log", "/home/flo/workspace/test-aspectj/weave.log",
+                         "-log", "weave.log",
                          "-bootclasspath", plugin.project.android.bootClasspath.join(File.pathSeparator)]

         MessageHandler handler = new MessageHandler(true);
Index: build.gradle
===================================================================
--- build.gradle    (revision 9d9c3ce4e0f903b5e7c650f231577c20585e6923)
+++ build.gradle    (revision )
@@ -5,7 +5,7 @@
     dependencies {
         classpath 'com.android.tools.build:gradle:0.12.+'
         // aspectj - http://fernandocejas.com/2014/08/03/aspect-oriented-programming-in-android/
-        classpath 'org.aspectj:aspectjtools:1.8.1'
+        classpath 'org.aspectj:aspectjtools:1.8.4'
     }
 }
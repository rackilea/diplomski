-injar classes
-injar /opt/local/share/scala-2.8/lib/scala-library.jar(!META-INF/MANIFEST.MF)
-outjar main.jar
-libraryjar /System/Library/Frameworks/JavaVM.framework/Versions/1.6/Classes/classes.jar

-dontwarn
-dontnote
-ignorewarnings

-optimizationpasses 2
-optimizations !code/allocation/variable

-keep,allowoptimization,allowshrinking class * { *; }
-keepattributes SourceFile,LineNumberTable

-keepclasseswithmembers public class your.Main { public static void main(java.lang.String[]); }
-dontshrink
    -verbose
    -dontwarn sun.reflect.**
    -dontwarn java.beans.**
    -keep,allowshrinking class com.esotericsoftware.** {
       <fields>;
       <methods>;
    }
    -keep,allowshrinking class java.beans.** { *; }
    -keep,allowshrinking class sun.reflect.** { *; }
    -keep,allowshrinking class com.esotericsoftware.kryo.** { *; }
    -keep,allowshrinking class com.esotericsoftware.kryo.io.** { *; }
    -keep,allowshrinking class sun.nio.ch.** { *; }
    -dontwarn sun.nio.ch.**
    -dontwarn sun.misc.**

    -keep,allowshrinking class com.snappydb.** { *; }
    -dontwarn com.snappydb.**
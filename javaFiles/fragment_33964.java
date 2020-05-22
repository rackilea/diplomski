wlan1-loopback% /usr/lib/jvm/java-8-oracle/bin/javap -c Test
Compiled from "Test.java"
public class Test {
  public Test();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]) throws java.lang.Exception;
    Code:
       0: invokedynamic #2,  0              // InvokeDynamic #0:run:()Ljava/lang/Runnable;
       5: astore_1
       6: aload_1
       7: invokeinterface #3,  1            // InterfaceMethod java/lang/Runnable.run:()V
      12: return
}
wlan1-loopback% java Test 
right
wlan1-loopback% java -version
java version "1.8.0_20"
Java(TM) SE Runtime Environment (build 1.8.0_20-b26)
Java HotSpot(TM) 64-Bit Server VM (build 25.20-b23, mixed mode)
wlan1-loopback%
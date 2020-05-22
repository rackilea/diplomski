public class Test extends java.lang.Object {
  public Test();
    Code:
       0: aload_0
       1: invokespecial #1
       4: return

  public static void main(java.lang.String[]
    Code:
       0: aload_0
       1: arraylength
       2: ifle          10
       5: iconst_1
       6: istore_1
       7: goto          12
      10: iconst_2
      11: istore_1
      12: return

  public static void main2(java.lang.String[
    Code:
       0: aload_0
       1: arraylength
       2: ifle          9
       5: iconst_1
       6: goto          10
       9: iconst_2
      10: istore_1
      11: return
}
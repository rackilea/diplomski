public class cli.CompareBoth {
  public cli.CompareBoth();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void lambda();
    Code:
       0: invokedynamic #2,  0              // InvokeDynamic #0:apply:()Ljava/util/function/Function;
       5: astore_1
       6: aload_1
       7: ldc           #3                  // String a
       9: invokeinterface #4,  2            // InterfaceMethod java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
      14: pop
      15: return

  public void anonymousClass();
    Code:
       0: new           #5                  // class cli/CompareBoth$1
       3: dup
       4: aload_0
       5: invokespecial #6                  // Method cli/CompareBoth$1."<init>":(Lcli/CompareBoth;)V
       8: astore_1
       9: aload_1
      10: ldc           #3                  // String a
      12: invokeinterface #4,  2            // InterfaceMethod java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
      17: pop
      18: return
}
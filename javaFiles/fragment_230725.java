class Demo$1$1 extends FooBar {
  final Demo$1 this$1;

  Demo$1$1(Demo$1);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #1                  // Field this$1:LDemo$1;
       5: aload_0
       6: invokespecial #2                  // Method FooBar."<init>":()V
       9: return

  void fooBarMethod();
    Code:
       0: aload_0
       1: getfield      #1                  // Field this$1:LDemo$1;
       4: invokevirtual #3                  // Method Demo$1.otherMethod:()V
       7: return
}
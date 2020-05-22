static {};
    Code:
       0: new           #4                  // class Foo
       3: dup
       4: ldc           #7                  // String A
       6: iconst_0
       7: invokespecial #8                  // Method "<init>":(Ljava/lang/String;I)V
      10: putstatic     #9                  // Field A:LFoo;
      13: new           #4                  // class Foo
      16: dup
      17: ldc           #10                 // String B
      19: iconst_1
      20: invokespecial #8                  // Method "<init>":(Ljava/lang/String;I)V
      23: putstatic     #11                 // Field B:LFoo;
      26: iconst_2
      27: anewarray     #4                  // class Foo
      30: dup
      31: iconst_0
      32: getstatic     #9                  // Field A:LFoo;
      35: aastore
      36: dup
      37: iconst_1
      38: getstatic     #11                 // Field B:LFoo;
      41: aastore
      42: putstatic     #1                  // Field $VALUES:[LFoo;
      45: return
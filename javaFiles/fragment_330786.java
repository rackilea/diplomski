static {};
    Code:
       0: new           #2                  // class Bar
       3: dup
       4: ldc           #3                  // String A
       6: invokespecial #4                  // Method "<init>":(Ljava/lang/String;)V
       9: putstatic     #5                  // Field A:LBar;
      12: new           #2                  // class Bar
      15: dup
      16: ldc           #6                  // String B
      18: invokespecial #4                  // Method "<init>":(Ljava/lang/String;)V
      21: putstatic     #7                  // Field B:LBar;
      24: iconst_2
      25: anewarray     #2                  // class Bar
      28: astore_0
      29: aload_0
      30: iconst_0
      31: getstatic     #5                  // Field A:LBar;
      34: aastore
      35: aload_0
      36: iconst_1
      37: getstatic     #7                  // Field B:LBar;
      40: aastore
      41: aload_0
      42: putstatic     #8                  // Field $VALUES:[LBar;
      45: return
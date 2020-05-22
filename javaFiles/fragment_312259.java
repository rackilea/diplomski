void conditional(double bar, boolean integer) {
  Object foo;

  if (integer) {
        foo = (int) bar;
  }
  else {
        foo = bar;
  }
}

  void conditional(double, boolean);
    Code:
       0: iload_3
       1: ifeq          14
       4: dload_1
       5: d2i
       6: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       9: astore        4
      11: goto          20
      14: dload_1
      15: invokestatic  #2                  // Method java/lang/Double.valueOf:(D)Ljava/lang/Double;
      18: astore        4
      20: return
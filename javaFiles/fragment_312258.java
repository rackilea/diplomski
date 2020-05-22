void ternary(double, boolean);
    Code:
       0: iload_3
       1: ifeq          10
       4: dload_1
       5: d2i
      // int promoted to double here.
       6: i2d
       7: goto          11
      10: dload_1
      // double autoboxed to Double here.
      11: invokestatic  #2                  // Method java/lang/Double.valueOf:(D)Ljava/lang/Double;
      14: astore        4
      16: return
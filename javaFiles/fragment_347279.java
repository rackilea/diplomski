// Finds the greater value in values that is below maximum.
    // Returns -1 if none is found. 
    public static int blabla(int[] values, int maximum) {
      int best_value = -1;
      for (int value : values) {
        if (value < maximum && value > best_value) {
          best_value = value;
        }
      }

      return best_value;
    }
boolean[] bools =
            { true, true, false, false, true, true, false, false, true
            };
        public static int binaryToInt(boolean[] bools) {
          int x = 0;
          for (boolean b : bools) {
             x <<= 1;
             x |= b ? 1
               : 0;
          }
          return x;
        }
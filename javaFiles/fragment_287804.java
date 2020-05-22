public static void stickParts(int minv, int ptr)
 {
      // "atleast" gives indexes in "parts" of groups which min digit
      // is at least "minv" (or only zeroes)
      for (int pi: atleast.get(minv)) {
            stick[ptr] = pi;
            if (ptr > 0) {
                 stickParts(Math.max(minv,maxi.get(pi)), ptr-1);
            }
            else {
                 // count solutions
                 // the number is made of "parts" from indexes
                 // stored in "stick"
                 num++;
            }
      }
 }
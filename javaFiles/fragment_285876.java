BiFunction<Integer, int[], Integer> func = (a, b) ->
      {
         for (int i = 0; i < b.length; i++) {
            a *= b[i];
         }
         return Integer.valueOf(a);
      };
public static void main(String[] args) {
      int[] v = { 1, 2, 3, 4
      };
      System.out.println(System.identityHashCode(v));
      test(v);
      System.out.println(Arrays.toString(v));
   }

   public static void test(int... vals) {
      System.out.println(System.identityHashCode(vals));
      vals[2] = 1000;
   }
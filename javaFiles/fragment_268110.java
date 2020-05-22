public static int fact(int n) {
     return ((Integer) new PatternMatching(
          inCaseOf(0, _ -> 1),
          otherwise(  _ -> n * fact(n - 1))
     ).matchFor(n));
}
public static <T extends Comparable> T median(T a, T b, T c) {
  if (a.compareTo(b) <= 0) {
    if (a.compareTo(c) <= 0) {
      return b.compareTo(c) <= 0 ? b : c; //a <= b && a <= c, return min(b, c)
    } else {
      return a;  //c < a <= b, return a
    }
  } else { // b < a
    if (a.compareTo(c) <= 0) {
      return a; // b < a <= c, return a
    } else {
      return b.compareTo(c) <= 0 ? c : b; //b < a && a > c, return max(b, c)
    }
  }
}
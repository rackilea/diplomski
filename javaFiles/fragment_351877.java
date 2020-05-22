// mirror an input string iteratively.
public static String mirror(String str) {
  // return str + reverse(str);
  StringBuilder sb = new StringBuilder(str);
  return str + sb.reverse().toString();
}
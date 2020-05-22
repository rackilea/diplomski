public static void ref(StringBuilder[] refSB) {
  refSB[0] = null;  // This works, outside the method the value will still be null
}

public static void main(String[] args) {
  StringBuilder[] sb = new StringBuilder[] { new StringBuilder() };
  ref(sb);
  System.out.println(sb[0]);  // Will print "null"
}
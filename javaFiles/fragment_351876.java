// Reverse the input String str.
private static String reverse(String str) {
  // This just looked ugly.
  if (str == null || str.length() <= 1) {
    return str;
  }
  // this is how you recursively reverse the word.
  return reverse(str.substring(1)) + str.charAt(0);
}

// mirror is trivial, the word and the reverse of the word.
public static String mirror(String str) {
  return str + reverse(str);
}

public static void main(String[] args) {
  String str = "apple";
  System.out.println(mirror(str));
}
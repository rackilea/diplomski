public static String fragment(String string, int index) {
  // TODO: regex probably not complete; ask stackoverflow!
  // see http://java.sun.com/javase/6/docs/api/java/text/MessageFormat.html
  final String regex = "\\{\\d.*?\\}";
  String[] fragments = string.split(regex, index + 2);
  return fragments[index];
  // TODO: error handling
}
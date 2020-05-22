public static String[] parseValue(String in) {
  String openTag = "<tag k=\"name\" v=\"";
  int p1 = in.indexOf(openTag);
  java.util.List<String> al = new java.util.ArrayList<String>();
  while (p1 > -1) {
    int p2 = in.indexOf("\"/>", p1 + 1);
    if (p2 > -1) {
      al.add(in.substring(p1 + openTag.length(), p2));
    } else {
      break;
    }
    p1 = in.indexOf(openTag, p2 + 1);
  }
  String[] out = new String[al.size()];
  return al.toArray(out);
}

public static void main(String[] args) {
  String myString = "Random_XML_Stuff_Here <tag k=\"name\" v=\"Example Road\"/> "
      + "More_Random_XML_Stuff <tag k=\"name\" v=\"Another name\"/>";
  System.out.println(java.util.Arrays
      .toString(parseValue(myString)));
}
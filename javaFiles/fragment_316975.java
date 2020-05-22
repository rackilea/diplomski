// Convert the string in to a Map<String, String>.
public static Map<String, String> toMap(String in) {
  // the return map.
  Map<String, String> map = new HashMap<String, String>();
  // a tokenizer on newline
  StringTokenizer st = new StringTokenizer(in, "\n");
  while (st.hasMoreTokens()) {      // while there are lines.
    String token = st.nextToken();  // get the line.
    String[] kv = token.split(":"); // split on colon.
    if (kv.length > 1) {            // check that there's a key and a
                                    // value.
      map.put(kv[0].trim(), kv[1].trim()); // add it to
                                           // the map.
    }
  }
  return map; // return the map.
}

public static void main(String[] args) {
  String str = "NAME : michael \nPHONE NO: 771234521\n"
      + " e-Mail: michael@gmai|.com \nCompany: Google\n";
  Map<String, String> map = toMap(str);
  System.out.println(map);
}
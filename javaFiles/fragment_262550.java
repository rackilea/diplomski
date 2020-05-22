HashMap map = new HashMap();

public void parse(String foo) {
  String foo2 = foo.substring(1, foo.length() - 1);  // hack off braces
  StringTokenizer st = new StringTokenizer(foo2, ",");
  while (st.hasMoreTokens()) {
    String thisToken = st.nextToken();
    StringTokenizer st2 = new StringTokenizer(thisToken, "=");

    map.put(st2.nextToken(), st2.nextToken());
  }
}

String getValue(String key) {
  return map.get(key).toString();
}
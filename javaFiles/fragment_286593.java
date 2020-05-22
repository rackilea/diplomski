Properties p = System.getProperties();
Enumeration keys = p.keys();
while (keys.hasMoreElements()) {
  String key = (String)keys.nextElement();
  String value = (String)p.get(key);
  w.println(key + ": " + value);
}
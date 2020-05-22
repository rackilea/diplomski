bw.write("#" + new Date().toString());
bw.newLine();
for (Enumeration e = keys(); e.hasMoreElements();) { // Here things go wrong!
  String key = (String)e.nextElement();
  String val = (String)get(key);
  key = saveConvert(key, true, escUnicode);
  val = saveConvert(val, false, escUnicode);
  bw.write(key + "=" + val);
  bw.newLine();
}
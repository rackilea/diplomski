public String toFixedLength(String str, int sz) {      
  String ret;
  int len = str.length();

  if (len == sz) {
    ret = str;
  } else if (len > sz) {
    ret = str.substring(0, sz);
  } else { // len < sz
    StringBuilder sb = new StringBuilder(str);

    char[] ch = new char[sz - len];
    Arrays.fill(ch, ' ');
    sb.append(ch);
    ret = sb.toString();
  }

  return ret;
}
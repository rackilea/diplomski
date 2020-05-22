Iterator<String> iter = data.iterator();
StringBuilder sb = new StringBuilder();
if (iter.hasNext()) {
  sb.append(iter.next());
  while (iter.hasNext()) {
    sb.append(separator).append(iter.next());
  }
}
String joined = sb.toString();
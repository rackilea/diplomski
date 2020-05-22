StringBuilder sb = new StringBuilder();
for (String str : numbers.split(";")) {
  sb.append("|(");
  sb.append(str);
  sb.append(")");
}
String result = sb.toString();
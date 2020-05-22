StringBuilder sb = new StringBuilder();
for (int i = arrList.size() - 1; i >= 0; i--) {
  int num = arrList.get(i);
  sb.append(num);
}
String result = sb.toString();
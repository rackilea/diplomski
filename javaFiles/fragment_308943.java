String sb = "";
for (int i = 0; i < dc.length(); i++) {
  char c = dc.charAt(i);
  int count = 1;
  while (i + 1 < dc.length() && (dc.charAt(i + 1)) == c) {
    count++;
    i++;
  }
  if (count > 1) {
    sb += count;
  }
  sb += c;
}

System.out.println(sb);
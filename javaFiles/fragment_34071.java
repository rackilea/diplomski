Pattern patt = Patter.compile("#([A-Z]{4})");
Matcher mat = patt.matcher(text);
StringBuffer buf = new StringBuffer();
while(mat.find()) {
  mat.appendReplacement(buf, mat.group(1).toLowerCase());
}
mat.appendTail(buf);
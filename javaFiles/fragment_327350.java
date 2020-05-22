StringBuffer result = new StringBuffer();
Matcher m = digitPattern.matcher(data);
while(m.find()) {
  m.appendReplacement(result, (m.group(1) == null ? "" : "$1"));
}
m.appendTail(result);
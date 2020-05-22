Pattern p = Pattern.compile("\\d+/\\d+/\\d+");
Matcher m = p.matcher(inputString);
while (m.find()) {
  // your triple is in group 0
  System.out.println(m.group(0));
}
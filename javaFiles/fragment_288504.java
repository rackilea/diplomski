String string = "...";

Pattern p = Pattern.compile("\\b(?<!')([xXzZ])(?!')\\b");
Matcher m = p.matcher(string);
if (m.find()) {
  String timeZone = m.group(1);
}
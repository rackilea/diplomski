String data = "s:64:\"first string\" random stuff here s:64:\"second string\"";
Pattern p = Pattern.compile("s:64:\"([^\"]*)\".*s:64:\"([^\"]*)\"");
Matcher m = p.matcher(data);
if (m.find()) {
  System.out.println("First string: '" + m.group(1) + "'");
  System.out.println("Second string: '" + m.group(2) + "'");
}
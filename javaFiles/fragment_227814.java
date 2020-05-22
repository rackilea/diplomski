String s = "<a>3</a>";
Pattern p = Pattern.compile("<a>(.*?)</a>")
Matcher m = p.matcher(s);
if (m.find()) {
  System.out.println(m.group(1)); // => "3"
}
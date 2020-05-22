String s = "This is a test [url] http://www.google.com.hk [/url]\n"
         + " and [img] http://www.abc.com/test.png [/img]";

Pattern p = Pattern.compile("\\[[^\\]]*\\]([^\\]]*)\\[[^\\]]*\\]");
Matcher m = p.matcher(s);
while (m.find()) {
  System.out.println(m.group(1).trim());
}
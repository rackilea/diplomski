String s  = "foobar!";
Pattern p = Pattern.compile("^\\w+(?=\\W)");
Matcher m = p.matcher(s);

if (m.find()) {
  System.out.println("Start:" + m.start() + " End:" + m.end());
  System.out.println(m.group());
}
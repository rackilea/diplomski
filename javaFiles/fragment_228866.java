String s  = "{one}{two}{three}";
Pattern p = Pattern.compile("\\{([^}]*)\\}");
Matcher m = p.matcher(s);
while (m.find()) {
  System.out.println(m.group(1));
}
Pattern p = Pattern.compile("host=([a-z0-9./:]*)");
Matcher m = p.matcher("host=http://sdf3452.domain.com/");
if (m.find()) {
  for(int i = 0; i <= m.groupCount(); i++) {
    System.out.printf("m.group(%d) = '%s'\n", i, m.group(i));
  }
}
Pattern hostP = Pattern.compile("host=([a-z0-9./:]*)");
Matcher m = hostP.matcher(content);

if(m.find()) {
  String match = m.group();
  // ... 
}
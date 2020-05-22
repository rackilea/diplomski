private static final Pattern pattern = Pattern.compile("<name>([^<]+)</name>");

Matcher m = pattern.compile(xmlString);
List<String> retList = new ArrayList<String>();
while(m.find()) {
    retList.add(m.group(1));
}
return retList;
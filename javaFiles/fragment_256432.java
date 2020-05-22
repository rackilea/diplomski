Map<String, String> map = new HashMap<String, String>();
map.put("1", "a");
map.put("2", "b");
String s = "#1 and #2";
Pattern p = Pattern.compile("#(\\d+)");
Matcher m = p.matcher(s);
StringBuffer buffer = new StringBuffer();
while (m.find()) {
    m.appendReplacement(buffer, map.get(m.group(1)));
}
System.out.println(buffer);
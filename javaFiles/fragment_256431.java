Map<String, String> map = new HashMap<String, String>();
map.put("1", "a");
map.put("2", "b");
String s = "#1 and #2";
Pattern p = Pattern.compile("#(\\d+)");
Matcher m = p.matcher(s);
while (m.find()) {
    String match = m.group(1);
    s = s.replaceAll("#"+match, map.get(match));
}
System.out.println(s);
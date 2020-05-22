Map<String, String> map = new HashMap<>();
map.put("a", "c");
map.put("b", "d");

String demo = "abcdef";

Pattern p = Pattern.compile("[ab]");
Matcher m = p.matcher(demo);

StringBuffer sb = new StringBuffer();
while (m.find()){
    m.appendReplacement(sb, map.get(m.group()));
}
m.appendTail(sb);
String replaced = sb.toString();

System.out.println(replaced);
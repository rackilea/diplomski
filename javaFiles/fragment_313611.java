Map<String, String> map = new HashMap<>();
map.put("a", "c");
map.put("b", "d");

String demo = "abcdef";

Pattern p = Pattern.compile("[ab]");
Matcher m = p.matcher(demo);

String replaced = m.replaceAll(match -> map.get(match.group()));
System.out.println(replaced);
String rx = "\\d+|[-?+]";
List<String> lst = new ArrayList<>();
Pattern p = Pattern.compile(rx);
Matcher m = p.matcher("(4, 9) ?, (741, 5) +, (555, 82) -,");
while (m.find()) {
    lst.add(m.group(0));
}
System.out.println(lst);
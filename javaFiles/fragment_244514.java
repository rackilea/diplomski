List<String> res = new ArrayList<String>();
Pattern p = Pattern.compile("([&]{1,2}|=>?| +)");
String s = "s=a&=>b";
Matcher m = p.matcher(s);
int pos = 0;
while (m.find()) {
    if (pos != m.start()) {
        res.add(s.substring(pos, m.start()));
    }
    res.add(m.group());
    pos = m.end();
}
if (pos != s.length()) {
    res.add(s.substring(pos));
}
for (String t : res) {
    System.out.println("'"+t+"'");
}
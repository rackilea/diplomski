String text = "elephant-rides are really fun!";
Pattern r = Pattern.compile("(?U)(\\w)(\\w{2,})(\\w)");
Matcher m = r.matcher(text);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, m.group(1) + m.group(2).length() + m.group(3));
}
m.appendTail(sb); // append the rest of the contents
System.out.println(sb);
// => e6t-r3s are r4y fun!
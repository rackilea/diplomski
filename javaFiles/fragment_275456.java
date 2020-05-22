String fileText = "pl???ugin??*.L???";
String pattern = "(?<q>\\?+)|(?<a>\\*+)";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(fileText);

StringBuffer sb = new StringBuffer();
while (m.find()) {
    if (m.group("q") != null)
    {
        m.appendReplacement(sb, "\\\\w{" + m.group("q").length() + "}");
    }
    else if (m.group("a") != null) 
    {
        m.appendReplacement(sb, "\\\\w+");
    }
}
m.appendTail(sb); // append the rest of the contents
System.out.println(sb);
str="Is ? stranded//?";
Pattern p = Pattern.compile("(?<!//)([?])");
m = p.matcher(str);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, m.group(1).replace("?", "Dave"));
}
m.appendTail(sb);
String s = sb.toString().replace("//", "");
System.out.println("Output: " + s);
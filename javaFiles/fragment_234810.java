StringBuilder sb = new StringBuilder();
Matcher m = Pattern.compile("([a-zA-Z])(.*?)([. -]+|$)").matcher(s);
while (m.find()) {
    sb.append(m.group(1).toUpperCase());
    sb.append(m.group(2).toLowerCase());
    sb.append(m.group(3));
}
System.out.println(sb.toString());
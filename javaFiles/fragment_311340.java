String str = "number(abc(kk)123)+status(open)";
Pattern p = Pattern.compile("([a-zA-Z0-9]+)\\((.*?)\\)(?=\\+|$)");
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.println(m.group(1) + ":" + m.group(2));
}
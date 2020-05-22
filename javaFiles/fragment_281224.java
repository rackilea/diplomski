String s = "(R0)(R10)(R001)(R000)";
Pattern p = Pattern.compile("\\(R0*(\\d+)\\)");

Matcher m = p.matcher(s);
while(m.find()) {
    System.out.println(m.group(1));
}
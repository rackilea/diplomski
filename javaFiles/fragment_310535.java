String range = "(15-42)";
String regexp = "(\\d{1,})-(\\d{1,})";
Pattern p = Pattern.compile(regexp);
Matcher m = p.matcher(range);
if (m.find()) {
    System.out.println(m.groupCount());
    for(int i=1; i<=m.groupCount(); i++){
        System.out.println("value:" + m.group(i));
    }
}
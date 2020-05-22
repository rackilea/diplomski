String dataPts = "requestparams=[id=4, isId=23], requestid=12345678, channel=BATCH";
String pattern = "\\b([^=]+=(?:\\[[^]]+\\]|[^=,]+))(?:,\\s*|$)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(dataPts);
while (m.find()) {
    System.out.println(m.group(1));
}
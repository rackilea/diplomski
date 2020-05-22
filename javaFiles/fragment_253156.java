String dataPts = "requestparams=[id=4, isId=23], requestid=12345678, channel=BATCH";
Map<String, String> map = new HashMap<>();
String pattern = "\\b([^=]+)=(\\[[^]]+\\]|[^=,]+)(?:,\\s*|$)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(dataPts);
while (m.find()) {
    map.put(m.group(1), m.group(2));
}
Matcher m = Pattern.compile("\\$(\\w*?)\\$").matcher(template);
Map<String, String> vars = new LinkedHashMap<String, String>();
while (m.find()) {
    System.out.println(m.group(1));
    vars.put(m.group(1), null);
}
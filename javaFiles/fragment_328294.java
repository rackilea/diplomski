Pattern p = Pattern.compile(" \\+\\w+");
Matcher m = p.matcher(s);
while (m.find()) {
    String key = m.group().trim().replaceAll("\\+","");
    System.out.println(key);
}
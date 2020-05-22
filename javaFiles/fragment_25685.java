Pattern p = Pattern.compile("\"?(.*?)\"?--\"?(.*?)\"? \\[(.*?)]");
Matcher m = p.matcher("\"San Diego\"--\"San Antonio\" [1319]");
if (m.find()) {
    System.out.println(m.group(1));
    System.out.println(m.group(2));
    System.out.println(m.group(3));
}
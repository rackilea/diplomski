String s = "[01.02.2016][0][]";
Pattern p = Pattern.compile("\\[([^\\]]*)\\]"); // pattern changed
Matcher m = p.matcher(s);
while (m.find()) {
    System.out.println("part = " + m.group(1)); // accessed group changed
}
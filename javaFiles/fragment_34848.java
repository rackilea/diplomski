Pattern p = Pattern.compile("i.*t");
String s = "my input string";
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println("match begins at " + m.start()); // 3
    System.out.println("match ends at " + m.end()); // 11
} else {
    System.out.println("no match found");
}
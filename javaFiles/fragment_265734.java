Pattern p = Pattern.compile("(?i)(\\b[a-z]+\\b)"); // <<=== Use \b
Matcher m = p.matcher(line);
Scanner sc = new Scanner(System.in); // <<== Scanner declared here
while (m.find()) {
    String targetStr = m.group();
    System.out.println("targetStr: " + targetStr );
    System.out.println("Enter a integer or a double value for the variable ");
    System.out.print("[" + targetStr + "]: ");
    String newStr = sc.next();
    line = line.replaceAll("\\b"+targetStr+"\\b", newStr); // <<=== Use \b
    System.out.println("After replacement: "+ line);
    m = p.matcher(line);
}
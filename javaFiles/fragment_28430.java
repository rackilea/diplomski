String s = "AAAAAAABBCCCDDABQ";
StringBuffer buf = new StringBuffer();
Pattern p = Pattern.compile("(A+B+)|(C+D+)");
Matcher m = p.matcher(s);
while (m.find()) {
    if (m.start(1) != -1) { // Group 1 found
        System.out.println("Found AB: " + m.group(1));
        m.appendReplacement(buf, ""); // Replace matched substring with ""
    } else if (m.start(2) != -1) { // Group 2 found
        System.out.println("Found CD: " + m.group(2));
        m.appendReplacement(buf, ""); // Replace matched substring with ""
    }
}
m.appendTail(buf);
String remain = buf.toString();
System.out.println("Remain: " + remain);
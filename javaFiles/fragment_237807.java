final Pattern p = Pattern.compile("\\{\\s*(\\w+)\\s*(,\\s*\"(.*?)\\s*\"\\s*)?\\}");
Matcher m1 = p.matcher("{hello, \"world\"}");
if (m1.matches()) {
    System.out.println("var1:" + m1.group(1));
    System.out.println("val1:" + m1.group(3));
}
Matcher m2 = p.matcher("{hello, \"wor\"rld\"}\"}");
if (m2.matches()) {
    System.out.println("var2:" + m2.group(1));
System.out.println("val2:" + m2.group(3));
}

/* Output
var1:hello
val1:world
var2:hello
val2:wor"rld"}
*/
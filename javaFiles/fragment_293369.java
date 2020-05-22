String str = "This is \"a string\" and this is \"a \\\"nested\\\" string\""; 
Pattern ptrn = Pattern.compile("\"[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*\"|\\S+");
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group(0));
}
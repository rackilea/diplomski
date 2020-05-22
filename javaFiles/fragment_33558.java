String str = "My work experience is 2 years\nMy work experience is 6 months";
String rx = "\\d+\\s+(?:months?|years?)";
Pattern ptrn = Pattern.compile(rx);
Matcher m = ptrn.matcher(str);
while (m.find()) {
     System.out.println(m.group(0));
}
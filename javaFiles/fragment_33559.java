String str = "My work experience is 2 years\nMy work experience is 3 years 6 months and his experience is 4 years and 5 months";
String rx = "\\d+\\s+years?\\s+(?:and\\s*)?\\d+\\s+months?|\\d+\\s+(?:months?|years?)";
Pattern ptrn = Pattern.compile(rx);
Matcher m = ptrn.matcher(str);
while (m.find()) {
    System.out.println(m.group(0));
}
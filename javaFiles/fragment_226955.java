public static void main(String[] args) {
String text = "sinXcos(b+c)tan(z)";
String patternString1 = "(sin|cos|tan)(?![a-z])\\(?\\w(\\+\\w)?\\)?";
Pattern pattern = Pattern.compile(patternString1);
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    System.out.println(matcher.group());
}
}



O/P:
sinX
cos(b+c)
tan(z)

2. Input :"sinabc(X+y)cos(b+c)tan(z)";
O/P :
cos(b+c)
tan(z)
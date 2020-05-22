String a = "HelloHelloHelloHello";
String b = "Hello";
int times = 0;
for (int i = 0; i <= a.length() - b.length(); i++) {
    String substring = a.subString(i, i + b.length());
    if (substring.equals(b)) {
        times = times + 1;
    }
}
System.out.println(times);
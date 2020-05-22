String a = "HelloHelloHelloHello";
String b = "Hello";
int times = 0;
for (int i = 0; i <= a.length() - b.length(); i++) {
    String substring = a.substring(i, i + b.length());
    for (int j = 0; substring.equals(b) && j < 1; j++) {
        times = times + 1;
    }
}
System.out.println(times);
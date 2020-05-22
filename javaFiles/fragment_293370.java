int cnt = 0;
String str = "This is \"a string\" and this is \"a \\\"nested\\\" string\""; 
Pattern ptrn = Pattern.compile("\"[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*\"|\\S+");
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    cnt++;
}
System.out.println(cnt);
String[] result = new String[cnt];
matcher.reset();
int idx = 0;
while (matcher.find()) {
    result[idx] = matcher.group(0);
    idx++;
}
System.out.println(Arrays.toString(result));
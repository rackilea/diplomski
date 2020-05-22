String ok_pattern = "(?<=\\[OK:)[^\\]]+|(?<=itId=<)[^>]+";
Pattern p_ok = Pattern.compile(ok_pattern);
String testString = "RANDOMTEXT itId=<1232> Code < [OK:AZ1000105]  [OK:10000006] [OK:F1000000007] > RANDOMTEXT";

Matcher m = p_ok.matcher(testString);
while (m.find()) {
    System.out.println(m.group(0));
}

1232
AZ1000105
10000006
F1000000007
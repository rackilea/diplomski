String str = "100\r\n000\r\n000";
System.out.println(str);

String[] str1dArray = str.split("\r\n");
String[][] str2dArray = new String[str1dArray.length][str1dArray[0].length()];
for (int i = 0; i < str1dArray.length; i++) {
    str2dArray[i] = str1dArray[i].split("");

    System.out.println(Arrays.toString(str2dArray[i]));
}
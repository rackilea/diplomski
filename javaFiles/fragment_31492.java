String charset = "abc";
String message = "abcabcabca";

char[] msgArr = message.toCharArray();
for (int i = 0; i < msgArr.length; i += 2) {
    System.out.println(msgArr[i] + "" + (i == msgArr.length - 1 ? "" : msgArr[i + 1]));
    System.out.println(charset.indexOf(msgArr[i]) + "" + (i == msgArr.length - 1 ? "" : charset.indexOf(msgArr[i + 1])));
}
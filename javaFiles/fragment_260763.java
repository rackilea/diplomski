String[] strArr = {"1", "2", "3"};
StringBuilder strBuilder = new StringBuilder();
for (int i = 0; i < strArr.length; i++) {
   strBuilder.append(strArr[i]);
}
String newString = strBuilder.toString();
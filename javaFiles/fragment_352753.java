List<String[]> data = getSqlReults();
String result = null;
for (String[] str : data) {
    if ("test".equals(str[0])) {
        result = str[1];
        break;
   }
}
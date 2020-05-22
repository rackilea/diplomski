...  
String patternString = "(\\d)\\s(\\d)\\sx.*?\\d\\.\\d\\d";
...
while (matcher.find()) {
    MyDataObj m = new MyDataObj();
    m.setSomeField(dataRows.add(matcher.group(1)));
    m.setAnotherField(dataRows.add(matcher.group(2)));
}
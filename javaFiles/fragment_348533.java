String s = "name1(value1),name2(value2),name3(value3),name4(value4),";

Pattern p = Pattern.compile(".*?\\((.*?)\\)");
Matcher m = p.matcher(s);

while(m.find()){
    System.out.println(m.group(1));
}
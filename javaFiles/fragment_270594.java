String text = "<div><ul ><li><span>answer 1.</span></li><li><span>answer 2</span></li><li><span>answer3.</span></li><li><span>answer 4</span></li></ul><div><span>Cat 1 | Cat 2 | Cat 3</span></div></div>";
Pattern pattern3 = Pattern.compile("<span.*?(?=</span>)");
Matcher matcher3 = pattern3.matcher(text);
String s = null;
while (matcher3.find()) {
    s = matcher3.group();
} 
System.out.println(s);
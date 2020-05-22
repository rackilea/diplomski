String s = "My name is David and I am (1) tall, and am perhaps also a (2) hobby programmer with (3) skills in various, and (4) things.";
Pattern pattern = Pattern.compile("\\(\\d+\\)(.*?)(?=$|\\(\\d+\\))");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}
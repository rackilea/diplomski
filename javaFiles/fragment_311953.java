String str = "a=\"First Field\" b=SecondField c=\"ThirdField\" d=\"FourthField\"";
Pattern p = Pattern.compile("(\\w+)=(?:\")?(.*?(?=\"?\\s+\\w+=|(?:\"?)$))");
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.println("key : " + m.group(1) + "\tValue : " + m.group(2));
}
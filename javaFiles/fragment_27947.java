String mydata = "nick=StringIWantIsHere,";
Pattern pattern = Pattern.compile("nick=(.*?),");
Matcher matcher = pattern.matcher(mydata);

if (matcher.find()) {
    System.out.println(matcher.group(1));
}
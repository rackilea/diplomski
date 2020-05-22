String text = "some text [Karan] some [test2] text [test3] [test4] 22[test5]";
Pattern pattern = Pattern.compile("(?<=\\[).*?(?=\\])");
//or use this regex,it works well too
//Pattern pattern = Pattern.compile("(?<=\\[)[^\\[\\]]*(?=\\])");
Matcher matcher = pattern.matcher(text);
while(matcher.find()){
    System.out.println(matcher.group());
}
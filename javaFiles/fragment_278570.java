String val="text KEYWORD1 text KEYWORD1 text KEYWORD2 text KEYWORD2";
String REGEX="KEYWORD1((.(?!KEYWORD1))+?)KEYWORD2";
Pattern pattern = Pattern.compile(REGEX);
Matcher matcher = pattern.matcher(val);
if(matcher.find()){
    System.out.println(matcher.group());
}
String s = "i am a sample string. \"name\":\"Alfred\",\"age\":\"95\",\"boss\":\"Batman\" end of sample";
Pattern regex = Pattern.compile("\"([^\"]*)\"");
ArrayList<String> allMatches = new ArrayList<String>();
Matcher matcher = regex.matcher(s);
while(matcher.find()){
        allMatches.add(matcher.group(1));
 }
System.out.println(allMatches);
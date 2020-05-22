Pattern pat = Pattern.compile("Building.+?(\\d+).+?[Dd].+?(\\d+)");
Matcher matcher = 
pat.matcher("Hello my is blah blah blah. Blah blah Building 5677 - Door 98 blah blah blah. ");
if (matcher.find()) {
   System.out.println(matcher.group(1));
   System.out.println(matcher.group(2));
}
String s = "type=INFO, languageCode=EN-GB, url=http://www.stackoverflow.com, ref=1, info=Text, that may contain all kind of chars., deactivated=false";

String[] possibleKeys = {"type","languageCode","url","ref","info","deactivated"};
String keysStrRegex = String.join("|", possibleKeys);
//above will contain type|languageCode|url|ref|info|deactivated

String regex = "(?<key>\\b(?:"+keysStrRegex+")\\b)=(?<value>.*?(?=, (?:"+keysStrRegex+")=|$))";
    // (?<key>\b(?:type|languageCode|url|ref|info|deactivated)\b)
    // =
    // (?<value>.*?(?=, (?:type|languageCode|url|ref|info|deactivated)=|$))System.out.println(regex);

Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(s);


while(m.find()){
    System.out.println(m.group("key")+" -> "+m.group("value"));
}
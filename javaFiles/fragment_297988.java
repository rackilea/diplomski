Pattern patternTag;
Matcher matcherTag;
String mypattern= "\\[mytag attr1=\"(.*?)\" attr2=\"(.*?)\" attr3=\"(.*?)\"\\s*](.+?)\\[/mytag]";
String term="[mytag attr1=\"20258044753052856\" attr2=\"A security \" attr3=\"cvvc\" ]TagTitle[/mytag]";
patternTag = Pattern.compile(mypattern);
matcherTag = patternTag.matcher(term);
while(matcherTag.find()){
       System.out.println(matcherTag.group(1)+"*********"+matcherTag.group(2)+"$$$$$$$$$$$$");
}
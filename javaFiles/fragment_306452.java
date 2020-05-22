String s = "type=INFO, languageCode=EN-GB, url=http://www.stackoverflow.com, ref=1, info=Text, that may contain all kind of chars., deactivated=false";

String regex = //type, info and deactivated are always present
          "type=(?<type>.*?)"
        + "(?:, languageCode=(?<languageCode>.*?))?"//optional group
        + "(?:, url=(?<url>.*?))?"//optional group
        + "(?:, ref=(?<rel>.*?))?"//optional group
        + ", info=(?<info>.*?)"
        + ", deactivated=(?<deactivated>.*?)";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(s);
if(m.matches()){
    System.out.println("type -> "+m.group("type"));
    System.out.println("languageCode -> "+m.group("languageCode"));
    System.out.println("url -> "+m.group("url"));
    System.out.println("rel -> "+m.group("rel"));
    System.out.println("info -> "+m.group("info"));
    System.out.println("deactivated -> "+m.group("deactivated"));
}
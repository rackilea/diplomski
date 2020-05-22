String input = " Paul Millsap Al Horford Tiago Splitter Jeff Teague Kyle Korver Thabo Sefolosha Mike Scott Shelvin Mack Kent Bazemore Dennis Schröder Tim Hardaway Jr. Walter Tavares Justin Holiday Mike Muscala Lamar Patterson Terran Petteway";
Pattern p = Pattern.compile("\\w+\\s+\\w+(\\s+Jr[.])?",
        Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
Matcher m = p.matcher(input);
while (m.find()) {
    System.out.println(m.group());
}
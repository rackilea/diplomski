String text = "resources/json/04-Dec/someName_SomeTeam.json";
String regex = "\\d{2}\\-[A-Z][a-z]{2}";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);
if (matcher.find()) {
    System.out.println(matcher.group());
}
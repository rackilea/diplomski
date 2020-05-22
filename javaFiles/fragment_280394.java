final String json = "\"name\" : \"john\" , \"worth\" : \"123,456\"";
final Pattern pattern =
    Pattern.compile("\"(.*?)\"\\s*:\\s*\"(.*?)\"", Pattern.DOTALL);
final Matcher matcher = pattern.matcher(json);
while(matcher.find()){
    System.out.println(matcher.group(1) + ":" + matcher.group(2));
}
Pattern pattern = Pattern.compile("Vol ([A-Z]{3}) Ch (\\d{3})");
Matcher matcher = pattern.matcher(input);
if(matcher.find()){
  String volume = matcher.group(1);
  String chapter = matcher.group(2);
}
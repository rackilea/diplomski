Pattern pattern = Pattern.compile(yourPattern);
Matcher matcher = patern.matcher(yourString);
while (matcher.find()) {
  String group = matcher.group(0);
  // do your if statement
}
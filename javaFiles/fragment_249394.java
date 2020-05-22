String str ="\"Java\",\"programming\"";
final Pattern pattern = Pattern.compile("\"([^\"]*)\"");
final Matcher matcher = pattern.matcher(str);
int i = 0
while(matcher.find()){
    System.out.println("match " + ++i + ": " + matcher.group(1) + "\n");
}
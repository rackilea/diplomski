final String regex = "([0-9]{1,})([a-zA-Z]{1,}[a-zA-Z0-9]{0,})";
final String string = "123ahaha1234";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}
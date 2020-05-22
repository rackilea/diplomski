final String regex = "(\\d+),(.*)";
final String string = "1,[103.85,1.28992],[103.89,1.294],[103.83,1.216]\n"
     + "2,[103.5,1.292],[103.9,1.4],[103.3,1.21]\n"
     + "3,[103.6,1.291],[103.6,1.39],[103.3,1.29]";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
}
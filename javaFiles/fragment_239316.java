final String regex = "[[\\P{L}хХxXтТTоОoO0]&&[^-_.]]";
final String string = "aTo-_.#$";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println(matcher.group(0));
}
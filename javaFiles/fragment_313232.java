Pattern pattern    = Pattern.compile("(?!\\.)(\\d+(\\.\\d+)+)(?![\\d\\.])");
Matcher matcher    = pattern.matcher(inputStr);
boolean matchFound = matcher.find();

if (matchFound)
{
    String version = matcher.group(1);
    System.out.println("Version number: " + version);
}
else
{
    System.out.println("No match for the input!");
}
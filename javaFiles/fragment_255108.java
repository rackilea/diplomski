final Pattern pattern = Pattern.compile("(\\d+) days (\\d\\d):(\\d\\d):(\\d\\d)");
final Matcher matcher = pattern.matcher(yourString);
if (matcher.find())
{
    days = Integer.parseInt(matcher.group(1));
    hours = Integer.parseInt(matcher.group(2));     
    minutes = Integer.parseInt(matcher.group(3));
    seconds = Integer.parseInt(matcher.group(4));
}
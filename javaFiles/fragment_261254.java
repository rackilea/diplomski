String line = "#food was testy. #drink lots of. #night was fab. #three #four";

Pattern pattern = Pattern.compile("#\\w+");

Matcher matcher = pattern.matcher(line);
while (matcher.find())
{
    System.out.println(matcher.group());
}
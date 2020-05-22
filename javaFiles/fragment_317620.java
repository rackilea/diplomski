String temp = "";
Pattern pattern = Pattern.compile("Gold(\\s{9})(\\d{4})\\.(\\d{2})");
Matcher matcher = pattern.matcher(str);

if (matcher.find())
{
    temp = temp + matcher.group();
}
else {
    System.out.println("No string found");
}
Pattern p = Pattern.compile("[A-Za-z]+");
Matcher m = p.matcher(expression);
while (m.find())
{
    varList.add(m.group());
}
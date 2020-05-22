Pattern p = Pattern.compile("([-+]?[0-9]*\\,?[0-9]+)\\s+smth");
Matcher matcher = p.matcher(result);
if(matcher.find())
{
    value = matcher.group(1); //get the first value found corresponding to the pattern 
}
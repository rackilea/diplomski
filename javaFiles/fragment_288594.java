protected static Pattern functionNameMatch;
protected static Pattern multipleFunctionsMatch;
static
{
    //TODO this method only works if all parameters are put on first line of function, otherwise declares function
    //is invalid
    functionNameMatch = Pattern.compile("function[ ]+([a-zA-Z0-9]*[ ]*\\(.*\\))");
    multipleFunctionsMatch = Pattern.compile("function[ ]+");
}

protected boolean isOneFunction()
{
    Matcher m = multipleFunctionsMatch.matcher(function.getText());
    if(m.find())
    {
        if(m.find())
        {
            return false;
        }
        return true;
    }
    return false;
}

protected String deriveNameFromFunction()
{
    Matcher m = functionNameMatch.matcher(function.getText());
    if(m.find())
    {
        return m.group(1);
    }
    return "";
}
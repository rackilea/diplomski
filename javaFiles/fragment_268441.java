public boolean isValid(String s)
{
    try
    {
        Long.parseLong(s);
    }
    catch(NumberFormatException e)
    {
        return false;
    }
    return true;
}
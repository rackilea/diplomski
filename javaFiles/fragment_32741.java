public String numOfDots(int count)
{
    StringBuilder retrStr = new StringBuilder();
    for (; count > 0; count--)
        retrStr.append("*");
    return retrStr.toString();
}
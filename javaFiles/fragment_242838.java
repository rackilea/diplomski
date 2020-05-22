public int count(String fullString, char valueToCount)
{
    int count = 0;
    for (int i=0; i < fullString.length(); i++)
    {
        if (fullString.charAt(i) == valueToCount)
             count++;
    }

    return count;
}
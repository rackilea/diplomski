int charToInt(char []data,int start,int end) throws NumberFormatException
{
    int result = 0;
    for (int i = start; i < end; i++)
    {
        int digit = (int)data[i] - (int)'0';
        if ((digit < 0) || (digit > 9)) throw new NumberFormatException();
        result *= 10;
        result += digit;
    }
    return result;
}
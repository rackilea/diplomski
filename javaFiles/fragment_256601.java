public static int countOddsInRange(int [] a, int first, int last)
{
    int count = 0;
    if(first <= last)
    {
        count+=countOddsInRange(a, first + 1, last);
        if(a[first] % 2 != 0)
        {
            count++;
        }
    }
    return count;   
}
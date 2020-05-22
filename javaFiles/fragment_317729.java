class Staircase2
{
    public static int counting(int n)
    {
        int result = 0;
        if (n >= 1) 
        {
            result += counting(n-1);
            if (n >= 2) 
            {
                result += counting(n-2);
                if (n >= 3) 
                {
                    result += counting(n-3);
                }
            }
        }
        else
        {
            result += 1;
        }
        return result;
    }
}
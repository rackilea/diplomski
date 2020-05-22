public static void markLastPrimeDivisor()
{
    // ...
    for(int i = 3 ; i < max_size; i++)
    {
        // ...
        if(i <= o)
        {
            for(int j = i * i ; j < max_size ; j += 2 * i)
            {
                lastPrimeDivisor[j] = i;
            }
        }
    }
}
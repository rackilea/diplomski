public void nextFactor() 
{
    for(int i = 2; i <= num; i++)
    {
        //check if the remainder is anything other then 0
        while (num >= i && num % i == 0)
        {
            System.out.println(i);
            num /= i;
        }           

    }

    System.out.println("Done.");
}
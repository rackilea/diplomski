public void nextFactor() 
{
    for(int i = 2; i <= num;)
    {
        //check if the remainder is anything other then 0
        if (num % i == 0)
        {
            System.out.println(i);
            num /= i;
        } else {
           i++;
        }

    }

    System.out.println("Done.");
}
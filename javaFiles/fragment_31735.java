public boolean isPrime(int number) 
{
    if (number == 1) 
    {
        return false;
    }
    for (int prime = 2; prime < number; prime++)
    {
        if (number % prime == 0) 
        {
            return false;
        }
    }
    return true;
}
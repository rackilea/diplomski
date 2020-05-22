static int sum_of_digit(int n) 
{  
    if (n < 10) 
        return n;

    return sum_of_digit(n % 10 + sum_of_digit(n / 10)); 
}
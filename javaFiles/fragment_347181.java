public int weirdRounding(int n)
{
    int last_Digit = n % 10;
    if(last_Digit  < 3) 
        return n - last_Digit;
    else if(last_Digit > 7)
        return n + (10 - last_Digit);
    else // the last digit is 3,4,5,6,7
        return n - (last_Digit) + 5;
}
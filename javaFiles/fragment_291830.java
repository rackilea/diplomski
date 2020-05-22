//This function checks if a specific number has only odd digits
private static boolean isHasAllDigitsOdd(int number)
{
    //first of all check if the number is 0
    if(number==0)
    {
        return false;
    }

    //while the last digit is odd cut that form the number
    while((number>0)&&(number%2==1))
    {
        number /= 10;
    }

    //if the number is 0 then all of its digits were cut
    if(number ==0)
    {
        return true;
    }
    else//otherwise it has a even digit
    {
        return false;
    }
}
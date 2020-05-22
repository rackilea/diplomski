while( number != 0 )
{
    reverse = reverse * 10;
    reverse = reverse + number%10;
    number = number/10;
}
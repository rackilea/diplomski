for(double i=0; i<SomeNumber; i++)
{
    if(i%2 == 0) // if the remainder of `i/2` is 0
        sum += -1 / ( 2 * i - 1);
    else
        sum += 1 / (2 * i - 1);
}
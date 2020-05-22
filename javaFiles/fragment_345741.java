while (b != 0)
{
    c = b & (0 - b);
    int index = Integer.numberOfTrailingZeros(c);
    //Do something...
    b = b ^ c;
}
private double discount(char chr)
{
    double   dDisc;
    dDisc = 0.00;

    while (chr == 'B')
    {
        if (balloons <10)
        {
            dDisc = 0.00;
            break;//add it here
        }
        else if (balloons >=10 && balloons <20)
        {
            dDisc = 0.10;
            break;//add it here
            ...
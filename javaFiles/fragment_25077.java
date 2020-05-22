for (int i = 0; i < x.length; i++)
{
    if (x[i] > x[i + 1])
    {
        placehold = x[i + 1];
        x[i] = x[i + 1];
        x[i + 1] = placehold;
    }   
}
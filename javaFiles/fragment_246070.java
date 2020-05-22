int highestDivi[] = new int[qtrs];

double highestDiv = 0;
for (int qtr = 0; qtr < qtrs; qtr++)
{
    highestDiv = 0;
    for (int div = 0; div < divs; div++)
    {
        if (highestDiv < sales[div][qtr])
        {
            highestDivi[qtr] = div;
            highestDiv=sales[div][qrt];
        }
    }
}
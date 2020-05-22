double[] neuesArray = new double[m.length];

int numOverAverage = 0;
for (double i : m)
{
    if (i > mittelw)
    {
        neuesArray[numOverAverage] = i;
        numOverAverage++;
    }
}
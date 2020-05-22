Integer previous = null;
for (int i = 0; i < sortedInts.length; i++)
{
    if (previous != null && previous >= sortedInts[i])
    {
        sortedInts[i] = previous + 1;
    }

    previous = sortedInts[i];
}
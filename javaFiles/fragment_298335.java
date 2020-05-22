for (int j = 0; j < array2.length; j++)
{
    double avg = (array[2 * j] + array[2 * j + 1]) / 2;
    if (array[2 * j] < 40 || array[2 * j + 1] < 40)
    {
        array2[j] = Math.min(avg, 40);
    } else {
        array2[j] = avg;
    }
}
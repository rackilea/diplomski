for (startScan = 0; startScan < (array.length - 1); startScan++)
{
    minIndex = startScan;
    minValue = array[startScan];

    for (index = startScan + 1; index < array.length; index++)
    {
        count2++;
        if (array[index] < minValue)
        {
            minValue = array[index];
            // count++; delete this
            minIndex = index;
        }
    }
    if (minIndex != startScan) {
        array[minIndex] = array[startScan];
        count++;
        array[startScan] = minValue;
    }
}
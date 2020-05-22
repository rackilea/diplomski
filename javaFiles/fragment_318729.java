for (int j=0; j < 5; j++) //finds five lowest...array not assigned values
{
    min[j] = max[4];                         // added line
    for (int i=5; i < numbers.length; i++)   // change to int i=5
    {
        if (numbers[i] < min[j])
        {...
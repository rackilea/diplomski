int unique(int[] array)
{
    int unpaired = array[0];
    for(int i = 1; i < array.length; i++)
        unpaired = unpaired ^ array[i];
    return unpaired;
}
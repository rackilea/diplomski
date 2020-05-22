private static int countEm(int[] array, boolean odd)
{
    int numEven = 0;
    for(int i=0; i< array.length; i++)
        if(array[i] % 2 == 0 )
            numEven++;             
    return odd?array.length-numEven:numEven;
}
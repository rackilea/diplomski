private static int countEm(int[] array, boolean odd)
{
    int numEven = 0;
    int numOdd = 0; 
    for(int i=0; i< array.length; i++)
        if(array[i] % 2 == 0 )   //You used / instead of % earlier!
            numEven++;
        else
            numOdd++; 

    if(odd)
        return numOdd;
    else
        return numEven; 
}
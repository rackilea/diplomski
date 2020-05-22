private void sortFlowers(String flowerPack[])
{
    //get the length of the array by counting arrays where the value is not null.
    int length = 0;
    for (int i = 0; i < flowerPack.length; i++)
    {
        if (flowerPack[i] != null)
        {
             length = length + 1;
        }
    }

    //just confirm that the count is correct.
    System.out.println(length);

    //set the length to the "length" variable as we have found above.
    for(int i = 0; i < length; i++)
    {         
        String currentMinFlow = flowerPack[i];
        int minIndex = i;
        for(int j = i; j < length;j++){
            if(currentMinFlow.compareToIgnoreCase(flowerPack[j]) <0)
            { 
                currentMinFlow = flowerPack[j];
                minIndex = j;
            }
        }
        if(minIndex != i){
            flowerPack[minIndex] = flowerPack[i];            
            flowerPack[i] = currentMinFlow;
        }
    }
}
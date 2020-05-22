public static int[] shrinkArray(int key)
{
    int[] resultArray = new int[myArray.length-1]; //One length less as we removed an item
    boolean found = false;
    for(int i = 0, j = 0; i < myArray.length; i++, j++)
    {
        if(!found && myArray[i] == key){ //if we find item first time
            i++;                        //skip it
            found = true;               //we found first occurrence
        }
        if(j < resultArray.length)
            resultArray[j] = myArray[i]; //copy array
    }
    if(found)
        return resultArray;
    return myArray;  //not found
}
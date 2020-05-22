public static String[] noDups(String[] myArray) { 

    int dups = 0; // represents number of duplicate numbers

    for (int i = 1; i < myArray.length; i++) 
    {
        // if number in array after current number in array is the same
        if (myArray[i].equals(myArray[i - 1]))
            dups++; // add one to number of duplicates
    }

    // create return array (with no duplicates) 
    // and subtract the number of duplicates from the original size (no NPEs)
    String[] returnArray = new String[myArray.length - dups];

    returnArray[0] = myArray[0]; // set the first positions equal to each other
                                 // because it's not iterated over in the loop

    int count = 1; // element count for the return array

    for (int i = 1; i < myArray.length; i++)
    {
        // if current number in original array is not the same as the one before
        if (!myArray[i].equals(myArray[i-1])) 
        {
           returnArray[count] = myArray[i]; // add the number to the return array
           count++; // continue to next element in the return array
        }
    }

    return returnArray; // return the ordered, unique array
}
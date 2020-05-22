private static int[][] getOccurrenceArray(int[][] input)
{
    // create a new 1D array that we'll shove
    // all indices of the 2D array into
    int[] inputCopy = new int[input.length * input[0].length];
    int index = 0;
    for (int i = 0; i < input.length; i++) {
        for (int j = 0; j < input[0].length; j++) {
            inputCopy[index] = input[i][j];
            index++;
        }
    }

    Arrays.sort(inputCopy);

    // find the number of unique values in the 1D array - this will be the length of 
    //the first dimension of your frequency array
    int uniqueValues = 1;
    int previouslySeen = inputCopy[0];
    for (int i = 1; i < inputCopy.length; i++) {
        // if value at the current index isn't the same as the value
        // at the previous index, we've found a new unique value
        if (inputCopy[i] != previouslySeen) {
            uniqueValues++;
        } 

        previouslySeen = inputCopy[i];
    }

    // create the frequency array
    int[][] frequencyArray = new int[uniqueValues][2];
    previouslySeen = inputCopy[0];
    int frequency = 0;
    index = 0;
    for (int i = 0; i < inputCopy.length; i++) {
        // if we haven't reached a new value, increment the frequency
        if (inputCopy[i] == previouslySeen) {
            frequency++;
        }
        // if we've reached a new value, assign the previous totals to
        // the array and reset frequency to 1
        else {
            frequencyArray[index][0] = previouslySeen;
            frequencyArray[index][1] = frequency;
            index++;
            frequency = 1;
        } 

        previouslySeen = inputCopy[i];
    }

    // don't forget to record the last value group
    frequencyArray[frequencyArray.length - 1][0] = previouslySeen;
    frequencyArray[frequencyArray.length - 1][1] = frequency;

    return frequencyArray;
}
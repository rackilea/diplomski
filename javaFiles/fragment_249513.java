public int[] Linear(int N, int start, int interval){

    // First declare the array.
    int[] linearArray = new int[N];

    // Declare something to hold the next value
    // The first value will be "start"

    int value = start;

    // Then, iterate over a for loop 
    for (int i = 0; i< N; i++){
        // assign the current value to the current indexed element in the array
        linearArray[i] = value;

        // compute next value
        value = value + interval;
    }

    // Finally, return your array
    return linearArray;
}
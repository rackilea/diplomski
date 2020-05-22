public static long insertionSort1(int[] intArray) {
    long startTime = System.currentTimeMillis();

    int n = intArray.length;
    for (int k = 1; k < n; k++) {         
        int cur = intArray[k];                
        int j = k;

        while (j > 0 && intArray[j-1] > cur) { // This loop can break early due 
                                               // to intArray[j-1] > cur
            intArray[j] = intArray[j-1];              
            j--;                              
        }
        intArray[j] = cur;                      
    }

    long endTime = System.currentTimeMillis();
    long elapsedTime = endTime - startTime;
    return elapsedTime;
}
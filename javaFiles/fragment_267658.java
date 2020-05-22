public int[] moveEvenToFront(int[] arr) {

    //declare a new array to populate with the result
    int[] result = new int[arr.length];
    int temp = 0;

    //add the evens
    for (int i = 0; i < result.length; i++) {
        if (arr[i] % 2 == 0) {
            result[temp] = arr[i];
            temp++;
        }
    }

    //add the odds
    for (int i = 0; i < result.length; i++) {
        if (arr[i] % 2 != 0) {
            result[temp] = arr[i];
            temp++;
        }
    }

    //return
    return result;
}
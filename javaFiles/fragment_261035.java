public static int[] slideAndSumArrayElements(int[] array, int[] result, int index) {
    // base case - stop when the index is same as the array.length
    if (index == array.length) {
        return result;
    } 
    else {
        // Add all elements of the array starting from the index position till length of the array and store the result in result[index]
        result[index] = addArrayElementsRecursively(array, index);

        // slide the main array by incrementing the index 
        return slideAndSumArrayElements(array, result, index + 1);
    }
}

public static int addArrayElementsRecursively(int[] arr, int index){
    // base case - when the index is same as the original array len stop
    if (arr.length == index){
        return 0;
    }

    // add progressively each element of the given array 
    return arr[index] + addArrayElementsRecursively(arr, index + 1);
}

public static void arraySum(){
    int[] array = {1, 2, 3, 4};
    int[] result = new int[array.length];

    result = slideAndSumArrayElements(array, result, 0);
}
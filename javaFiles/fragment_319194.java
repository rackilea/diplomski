public static int[] getMax(int[] arr, int[] retArr) {
    // Return case
    if (retArr[1] >= arr.length - 1)
        return new int[] { Integer.MIN_VALUE, retArr[1] };

    // Save context
    int index = retArr[1];
    int value = arr[index] - arr[index + 1];

    // Call recursion
    retArr[1]++;
    int[] temp = getMax(arr, retArr);

    // Return best between current case and recursive case
    if (temp[0] > value)
        return temp;
    else
        return new int[] { value, index };
}
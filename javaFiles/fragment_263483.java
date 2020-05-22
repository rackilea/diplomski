int arr[] = {96, 1, 23, 47, 81, 92, 52, 48, 56, 66, 65, 96, 81, 6};
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    // check the condition
    for (int i = 0; i < arr.length; i++) {
        // this condition check for largest number
        if (arr[i] > largest) {
            secondLargest = largest;
            largest = arr[i];
        } else if (arr[i] > secondLargest && arr[i] < largest) {
            secondLargest = arr[i];
        }
    }
public static int[] twoLargest(int values[]){
    int largestA = Integer.MIN_VALUE, largestB = Integer.MIN_VALUE;

    for(int value : values) {
        if(value > largestA) {
            largestB = largestA;
            largestA = value;
        } else if (value > largestB) {
            largestB = value;
        }
    }
    return new int[] { largestA, largestB }; 
}
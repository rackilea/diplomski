public static boolean areNumbersInclusive(int[] arr) {
    long sum = 0;

    for (int n : arr) {
        if (n > arr.length - 1 || n < 0) {
            return false;
        }
        sum += n;
    }

    long intendedSum = ((arr.length - 1) * arr.length) / 2; // sum from 1 to n is n*(n+1)/2

    return intendedSum == sum;
}

public static void main(String args[]) {
    int[] arr1 = {1,0,5,3,2,4};
    int[] arr2 = {1,0,3,4};
    int[] arr3 = {-1,0,3,2};
    int[] arr4 = {1,0,3,2};

    System.out.println(areNumbersInclusive(arr1));
    System.out.println(areNumbersInclusive(arr2));
    System.out.println(areNumbersInclusive(arr3));
    System.out.println(areNumbersInclusive(arr4));
}
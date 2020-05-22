public static int rowWithMostZeros(int[][] arr) {

    if (arr == null || arr.length < 1) {
        return -1;
    }

    int rowWithMostZeros = 0;
    int count = countZeros(arr[0]);

    for (int i = 1; i < arr.length; i++) {
        int count2 = countZeros(arr[i]);
        if (count2 > count) {
            rowWithMostZeros = i;
        }
    }

    return rowWithMostZeros;
}

public static int countZeros(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 0) {
            count += 1;
        }
    }
    return count;
}
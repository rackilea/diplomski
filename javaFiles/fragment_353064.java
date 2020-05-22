public static int[] removeFromIndex(int[] myArray, int num) {
        int[] resultArray = new int[myArray.length - 1];
        for (int i = 0, j = 0; i < myArray.length; i++) {
            if (myArray[i] != num) {
                resultArray[j++] = myArray[i];
            }
        }
        return resultArray;
    }
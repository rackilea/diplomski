int[] checkArr(int[] arr1, int[] arr2) {
        int[] arr = new int[array1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = Integer.MIN_VALUE;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    arr[i] = arr1[i];
                }

            }
        }
        return arr;

    }
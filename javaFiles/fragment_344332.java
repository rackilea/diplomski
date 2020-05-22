public static void merge(String[] arr, String[] left, String[] right){
        int l = 0;
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (l < left.length && r < right.length) {
                if (left[l].compareTo(right[r]) <= 0)
                    arr[i] = left[l++];
                else
                    arr[i] = right[r++];;
            } else if (l < left.length) {
                arr[i] = left[l++];
            } else {
                arr[i] = right[r++];
            }
        }
    }
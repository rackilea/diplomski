else {
        for (int i = 1; i <= range; i++) {
            if (index == 0) {
                arr[index] = i;
                printRecList(k - 1, arr, index + 1, range);
            } else {
                int t = arr[index-1]-i;
                t = t > 0 ? t : -t;
                if (t < 2) {
                    arr[index] = i;
                    printRecList(k - 1, arr, index + 1, range);
                }
            }
        }
    }
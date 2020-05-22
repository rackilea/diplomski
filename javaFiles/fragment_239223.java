int pivotIndex = arr.size() / 2;
    int pivot = arr.get(pivotIndex);
    for (int n : arr) {
        if (n < pivot) {
            less.add(n);
        }
        else {
            more.add(n);
        }
    }
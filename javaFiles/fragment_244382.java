public boolean hasDuplicates(int[] arr) {
    boolean found = false;
    for (int i = 1 ; i <= arr.length ; i++) {
        for (int a : arr) 
            if (a == i) found = true;
        if (! found) return true;
    }
    return false;
}
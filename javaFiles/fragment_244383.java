public boolean hasDuplicates(int[] arr) {
    int[] newarr = new int[arr.length];
    for (int a : arr) newarr[a - 1]++;
    for (int a : newarr) if (a != 1) return true;
    return false;
}
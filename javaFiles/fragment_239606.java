static int[] oddNumbers(int l, int r) {
    if (r <= l) return null;

    l = (l % 2) == 0 ? l + 1 : l;
    int size = ((r - l) / 2) + 1;

    int[] theArray = new int[size];

    for (int i=0; i < size; ++i) {
        theArray[i] = l + (i*2);
    }

    return theArray;
}
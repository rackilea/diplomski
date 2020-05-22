int[] numbers = {0,1,2,3,4,5,6,7,8,9,10};

public void traverseReversed(int[] a) {
    traverseReversed(a, 0);
}

private void traverseReversed(int[] a, int i) {
    if ( i + 1 < a.length ) {
        // Traverse the rest of the array first.
        traverseReversed(a, i+1);
    }
    System.out.println(a[i]);
}

public void test() throws Exception {
    System.out.println("Hello world!");
    traverseReversed(numbers);
}
public static void main(String [] args) {

    int [] arr = {1, 5, 4, 3, 3, 4, 3, 1};
    int ARRAYSIZE = arr.length;

    for (int i = 0; i < ARRAYSIZE; i++) {
        int index = i % ARRAYSIZE;
        int indexUpper = (i + 1) % ARRAYSIZE;
        //access array using index
        if (arr[index] == arr[indexUpper]) {
            System.out.format("Elements %d and %d are equals.\n", index, indexUpper);
        }
    }
}
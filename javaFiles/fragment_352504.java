public static void main(String[] args) {
    int[] myArray = {1, 2, 3};

    for (int i = 0; i < 6; i++) {
        int idx = i % (myArray.length - 1);
        print(myArray);
        int temp = myArray[idx];
        myArray[idx] = myArray[idx + 1];
        myArray[idx + 1] = temp;
    }
}
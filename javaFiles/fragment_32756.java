public static void main(String[] args) {
    int[] myArray = { 9, 6, 1, 3, 0, 4, 2 };

    for (int i = 0; i < myArray.length; i++) {
        swap(myArray, i, findMIN(myArray, i));
    }
    System.out.println(Arrays.toString(myArray));
}
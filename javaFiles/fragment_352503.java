public static void main(String[] args) {
    int[] myArray = {1, 2, 3};
    for (int i = 0; i < 6; i++) {
        print(myArray);
        int temp = myArray[i % myArray.length];
        myArray[i % myArray.length] = myArray[(i + 1) % myArray.length];
        myArray[(i + 1) % myArray.length] = temp;
    }
}

private static void print(int[] array) {
    for (int anArray : array) {
        System.out.print(anArray + " ");
    }
    System.out.println("");
}
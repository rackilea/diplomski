public static class BubbleSort { //you need static here

    public static void main(String[] args) {
        int intArray[] = new int[] { 5, 90, 35, 45, 150, 3 };
        System.out.println("Array before Bubble Sort");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        bubbleSort(intArray);
        System.out.println("");
        System.out.println("Array after Bubble Sort");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " "); // you need space between the parenthesis so that results show up readable
        }
    }

    private static void bubbleSort(int[] intArray) {
        int n = intArray.length;
        int hold = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < (n - i - 1); j++){ // j has to be equal to 0, or your first value in the array won't get compared, and -1 because of the array out of bounds error
                if (intArray[j] > intArray[j + 1]){
                    hold = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = hold;
                }
            }
        }
    }
}
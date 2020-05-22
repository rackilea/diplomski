class main {
public static void main(String[] args) {
    int[] array = new int[11];
    {
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        array[5] = -1;
        array[6] = -2;
        array[7] = -3;
        array[8] = -4;
        array[9] = -5;
        array[10] = -6;
        swapMinMaxBetter(array);
        max(array);
        min(array);
    }
}
    public static int min(int[] array) {
        int smallest = array[0];
        int smallestIndex = 0

        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallestIndex = i;
            }
        }
        System.out.println("MIN: " + smallest);
        return smallestIndex;
    }
    public static int max(int[] array) {
        int largest = array[0];
        int largestIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
                largestIndex = i;
            }
        }
        System.out.println("MAX: " + largest);
        return largestIndex;
    }
    public static void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
    public static void swapMinMaxBetter(int[] array) {
        int smallest = min(array);
        int largest = max(array);
        swap(array, smallest, largest);
    }
}
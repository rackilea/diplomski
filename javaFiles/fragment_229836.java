public static void main(String[] args) {
    int[] array = {6, 3, 3, 6, 6, 6, 4, 4, 20};
    int min = array[0];
    int max = array[0];
    // Find min max
    for (int i : array) {
        if (i < min) {
            min = i;
        }
        if (i > max) {
            max = i;
        }
    }
    // Use array to sum up all elements
    int[] holderArray = new int[max - min + 1];
    for (int i : array) {
        holderArray[i - min]++;
    }
    // Calculate occurrence and sums
    for(int i = 0; i < holderArray.length; i++) {
        if(holderArray[i] > 0) {
            System.out.printf("number: %2d; count: %2d; sum: %2d%n", i + min, holderArray[i], (i + min) * holderArray[i]);
        }
    }
}
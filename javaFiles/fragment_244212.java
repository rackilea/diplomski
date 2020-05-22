public class Main {

    // ...
    // Your copy2DArray method goes here
    // ...

    public static void main(String[] args) {
        // The array to copy
        Integer array[][] = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}
        };

        // Create a copy of the array
        Integer copy[][] = clone2DArray(array);

        // Print the copy of the array
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                System.out.print(copy[i][j] + " ");
            }

            System.out.println();
        }
    }
}
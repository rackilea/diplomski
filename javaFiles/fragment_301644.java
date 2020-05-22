import java.util.Arrays;

public class ArrayRange {

    public static void main(String[] args) {

        char[][] original = createMatrix(4);

        // copy 3x3 array starting at 1,0
        char[][] subArray = copySubrange(original, 1, 0, 3, 3);

        printArray(original);
        printArray(subArray);
    }

    private static char[][] copySubrange(char[][] source, int x, int y, int width, int height) {
        if (source == null) {
            return null;
        }
        if (source.length == 0) {
            return new char[0][0];
        }
        if (height < 0) {
            throw new IllegalArgumentException("height must be positive");
        }
        if (width < 0) {
            throw new IllegalArgumentException("width must be positive");
        }
        if ((y + height) > source.length) {
            throw new IllegalArgumentException("subrange too high");
        }
        char[][] dest = new char[height][width];
        for (int destY = 0; destY < height; destY++) {
            char[] srcRow = source[(y + destY)];
            if ((x + width) > srcRow.length) {
                throw new IllegalArgumentException("subrange too wide");
            }
            System.arraycopy(srcRow, x, dest[destY], 0, width);
        }
        return dest;
    }

    // Set up a matrix as an array of rows.
    // The y-coordinate is the position of a row in the array.
    // The x-coordinate is the position of an element in a row.
    private static char[][] createMatrix(int size) {
        char[][] original = new char[size][size];
        for (int y = 0; y < original.length; y++) {
            for (int x = 0; x < original[0].length; x++) {
                original[y][x] = (char) (Math.random() * 10 + 48);
            }
        }
        return original;
    }

    private static void printArray(char[][] array) {
        for (int y = 0; y < array.length; y++) {
            System.out.println(Arrays.toString(array[y]));
        }
        System.out.println();
    }
}
import java.util.Arrays;   

public class Ctest {
    public static void main(String[] args) {
        char[][] word= { {'a', 'b'}, {'c', 'd'}, {'e', 'f'} };

        println(word); // format with brackets e.g., [[a, b], [c, d]]
        System.out.println(Arrays.deepToString(word)); // same format

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[i].length; j++) {
                if (word[i][j] >= 'a' && word[i][j] <= 'f') {
                    word[i][j] = (char) ((word[i][j] - 'a') + '0');
                }
            }
        }

        println(word); // formatted with brackets
        printPlain(word); // formatted without brackets
    }

    public static void println(char[][] word) {
        System.out.print("[");
        for (int i = 0; i < word.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print("[");
            for (int j = 0; j < word[i].length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(word[i][j]);
            }
            System.out.print("]");
        }
        System.out.println("]");
    }

    public static void printPlain(char[][] word) {
        for (int i = 0; i < word.length; i++) {
            if (i > 0) System.out.print(", ");
            for (int j = 0; j < word[i].length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(word[i][j]);
            }
        }
        System.out.println();
    }
}
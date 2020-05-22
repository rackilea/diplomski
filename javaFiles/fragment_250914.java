import java.util.Deque;
import java.util.ArrayDeque;

public class SubarraySums {

    /** Program entry point */
    public static void main(String[] args) {
        int[] array = { 1, 8, 7, 9, 5, 2 };
        findSubarraySums(12, array);
    }

    /** Wrapper function for the search */
    public static void findSubarraySums(int goal, int[] array) {
        // Search the whole array with an empty starting set
        search(goal, new ArrayDeque<Integer>(), array, 0);
    }

    /** Helper for printing an answer */
    private static void printAnswer(Deque<Integer> xs) {
        // Print the sum
        int sum = 0;
        for (int x : xs) sum += x;
        System.out.printf("%d =", sum);
        // Print the elements
        for (int x : xs) {
            System.out.printf(" %d", x);
        }
        System.out.println();
    }

    /**
     * Search the array, starting from index i,
     * for a subset summing to n.
     * The list xs includes all of the elements that are already
     * assumed to be included in this answer
     */
    private static void search(int n, Deque<Integer> xs, int[] array, int i) {
        // Base case: we've reached zero!
        if (n == 0) {
            printAnswer(xs);
            return;
        }
        // Base case: solution not found
        if (n < 0 || i >= array.length) return;
        // Recursive case: try searching with and without current element
        // with:
        xs.addLast(array[i]);
        search(n-array[i], xs, array, i+1);
        // without:
        xs.removeLast();
        search(n, xs, array, i+1);
    }

}
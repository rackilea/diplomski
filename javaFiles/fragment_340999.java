import java.util.*;
import static java.lang.System.out;

class Main {
    public static LinkedList<Integer> add(
        LinkedList<Integer> a, LinkedList<Integer> b
    ) {
        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> xIt = a.iterator();
        Iterator<Integer> yIt = b.iterator();
        int rem = 0;

        while (xIt.hasNext() || yIt.hasNext()) {
            int x = xIt.hasNext() ? xIt.next() : 0;
            int y = yIt.hasNext() ? yIt.next() : 0;
            result.add((x + y + rem) % 10);
            rem = x + y + rem >= 10 ? 1 : 0;
        }

        if (rem > 0) {
            result.add(rem);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {143, 675},
            {77666, 666},
            {985, 824},
            {9999, 1},
            {1, 9999},
            {667, 677},
        };

        for (int[] test : tests) {
            LinkedList<Integer> a = itol(test[0]);
            LinkedList<Integer> b = itol(test[1]);
            LinkedList<Integer> sum = add(a, b);
            int expected = test[0] + test[1];

            out.println("a   : " + a + "\n" + "b   : " + b);
            out.println("sum : " + sum);
            out.println(test[0] + " + " + test[1] + " = " + ltoi(sum));
            out.println("Correct? " + (ltoi(sum) == expected) + "\n");
        }
    }

    private static LinkedList<Integer> itol(int i) {
        LinkedList<Integer> res = new LinkedList<>();

        for (; i > 0; i /= 10) res.offer(i % 10);

        return res;
    }

    private static int ltoi(LinkedList<Integer> ll) {
        String digits = "";

        for (int i : ll) digits = i + digits;

        return Integer.parseInt(digits);
    }    
}
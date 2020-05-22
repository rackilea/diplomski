public class TurboAdder {
    private static final int[] data = new int[] { 5, 10, 20, 25, 40, 50 };

    private static class Node {
        public final int index;
        public final int count;
        public final Node prevInList;
        public final int prevSum;
        public Node(int index, int count, Node prevInList, int prevSum) {
            this.index = index;
            this.count = count;
            this.prevInList = prevInList;
            this.prevSum = prevSum;
        }
    }

    private static int target = 100;
    private static Node sums[] = new Node[target+1];

    // Only for use by printString.
    private static boolean forbiddenValues[] = new boolean[data.length];

    public static void printString(String prev, Node n) {
        if (n == null) {
            System.out.println(prev);
        } else {
            while (n != null) {
                int idx = n.index;
                // We prevent recursion on a value already seen.
                if (!forbiddenValues[idx]) {
                    forbiddenValues[idx] = true;
                    printString((prev == null ? "" : (prev+" + "))+data[idx]+"*"+n.count, sums[n.prevSum]);
                    forbiddenValues[idx] = false;
                }
                n = n.prevInList;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            for (int count = 1, sum = value; count <= 100 && sum <= target; count++, sum += value) {
                for (int newsum = sum+1; newsum <= target; newsum++) {
                    if (sums[newsum - sum] != null) {
                        sums[newsum] = new Node(i, count, sums[newsum], newsum - sum);
                    }
                }
            }
            for (int count = 1, sum = value; count <= 100 && sum <= target; count++, sum += value) {
                sums[sum] = new Node(i, count, sums[sum], 0);
            }
        }
        printString(null, sums[target]);

    }
}
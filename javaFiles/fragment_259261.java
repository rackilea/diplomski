public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testsCount = in.nextInt();
        for (int t = 0; t < testsCount; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            // Simulates all rotations,
            // but keeps track only of the k-th ball.
            // It does not matter what happens to the others.
            for (int i = 0; i < n; i++) 
                if (k >= i)
                    k = i + n - 1 - k;
            out.println(k);
        }
        out.flush();
    }
}
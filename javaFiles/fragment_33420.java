public class HelloWorld {
    public static int c = 0, j, i, n, l, r, x;
    public static Vector<Vector<Integer>> v = new Vector();

    // each combination of the elements should have an independent vector;
    public static void f(Vector<Integer> m, int k) {
        if (k == n + 1) {
            v.add(m);
            return;
        } // the unique vector;
        f(new Vector<>(m), k + 1); // create a new vector to store the elements;
        m.add(k);
        f(new Vector<>(m), k + 1); // same logic applied here;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        Vector<Integer> u = new Vector<Integer>();
        f(new Vector<>(), 0);
        for (i = 0; i < v.size(); i++) {
            for (int j : v.get(i)) System.out.print(j + " ");
            System.out.print("\n");
        }
    }
}
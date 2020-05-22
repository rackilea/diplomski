private static class Lexical implements Comparator<double[]> {

    @Override
    public int compare(double[] o1, double[] o2) {
        for (int i = 0; i < o1.length && i < o2.length; i++) {
            if (o1[i] != o2[i]) {
                return o1[i] - o2[i] > 0 ? 1 : -1;
            }
        }

        if (o2.length != o1.length) {
            // how to compare these?
            return o1.length - o2.length;
        }
        return 0;
    }
}

public static void main(String[] args) {
    double[][] a = { { 1, 2 }, { 2, 4 }, { 2, -2 } };
    Arrays.sort(a, new Lexical());
    }
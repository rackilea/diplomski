public class DoubleIndexSort {

    static class DI implements Comparable<DI> {
        final int index;

        final double val;


        DI(double v, int i) {
            val = v;
            index = i;
        }


        public int compareTo(DI other) {
            if (val < other.val) {
                return 1;
            } else if (val == other.val) {
                return 0;
            }
            return -1;
        }
    }



    public static void checkResult(double[] test, int[] indexes) {
        for(int i = 0;i < indexes.length;i++) {
            int ii = indexes[i];
            double iv = test[ii];
            // System.out.println("Checking " + i + " -> " + ii + " = " + iv);
            for(int j = 0;j < test.length;j++) {
                // System.out.println(j + " -> " + test[j]);
                if (j != ii && test[j] > iv) throw new RuntimeException();
            }
            test[ii] = -1;
        }
    }


    public static int[] getHighestIndexes(double[] data, int topN) {
        if (data.length <= topN) {
            return sequence(topN);
        }
        int[] bestIndex = new int[topN];
        double[] bestVals = new double[topN];

        bestIndex[0] = 0;
        bestVals[0] = data[0];

        for(int i = 1;i < topN;i++) {
            int j = i;
            while( (j > 0) && (bestVals[j - 1] < data[i]) ) {
                bestIndex[j] = bestIndex[j - 1];
                bestVals[j] = bestVals[j - 1];
                j--;
            }
            bestVals[j] = data[i];
            bestIndex[j] = i;
        }

        for(int i = topN;i < data.length;i++) {
            if (bestVals[topN - 1] < data[i]) {
                int j = topN - 1;
                while( (j > 0) && (bestVals[j - 1] < data[i]) ) {
                    bestIndex[j] = bestIndex[j - 1];
                    bestVals[j] = bestVals[j - 1];
                    j--;
                }
                bestVals[j] = data[i];
                bestIndex[j] = i;
            }
        }

        return bestIndex;
    }


    public static int[] getHighestIndexes2(double[] data, int topN) {
        if (data.length <= topN) {
            return sequence(topN);
        }
        DI[] di = new DI[data.length];
        for(int i = 0;i < data.length;i++) {
            di[i] = new DI(data[i], i);
        }
        Arrays.sort(di);        

        int[] res = new int[topN];
        for(int i = 0;i < topN;i++) {
            res[i] = di[i].index;
        }
        return res;
    }


    public static int[] getHighestIndexes3(double[] data, int topN) {
        if (data.length <= topN) {
            return sequence(topN);
        }
        SortedSet<DI> set = new TreeSet<DI>();
        for(int i=0;i<data.length;i++) {
            set.add(new DI(data[i],i));
        }
        Iterator<DI> iter = set.iterator();
        int[] res = new int[topN];
        for(int i = 0;i < topN;i++) {
            res[i] = iter.next().index;
        }
        return res;
    }


    public static int[] getHighestIndexes4(double[] data, int topN) {
        if (data.length <= topN) {
            return sequence(topN);
        }
        SortedSet<DI> set = new TreeSet<DI>();
        for(int i=0;i<data.length;i++) {
            set.add(new DI(data[i],i));
            if( set.size() > topN ) {
                set.remove(set.last());
            }
        }
        Iterator<DI> iter = set.iterator();
        int[] res = new int[topN];
        for(int i = 0;i < topN;i++) {
            res[i] = iter.next().index;
        }
        return res;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        long elap1 = 0;
        long elap2 = 0;
        long elap3 = 0;
        long elap4 = 0;
        for(int i = 1;i <= 1000;i++) {
            double[] data = testData();
            long now = System.nanoTime();
            int[] inds = getHighestIndexes(data, 100);
            elap1 += System.nanoTime() - now;
            checkResult(data, inds);
            System.out.println("\nInsert sort: "+(elap1 / i));

            now = System.nanoTime();
            inds = getHighestIndexes2(data, 100);
            elap2 += System.nanoTime() - now;
            checkResult(data, inds);
            System.out.println("Object sort: "+(elap2 / i));

            now = System.nanoTime();
            inds = getHighestIndexes3(data, 100);
            elap3 += System.nanoTime() - now;
            checkResult(data, inds);
            System.out.println("Sorted set:  "+(elap3 / i));

            now = System.nanoTime();
            inds = getHighestIndexes4(data, 100);
            elap4 += System.nanoTime() - now;
            checkResult(data, inds);
            System.out.println("Limited set: "+(elap4 / i));
        }
    }


    private static int[] sequence(int n) {
        int[] indexes = new int[n];
        for(int i = 0;i < n;i++) {
            indexes[i] = i;
        }
        return indexes;
    }


    public static double[] testData() {
        double[] test = new double[3000];
        for(int i = 0;i < test.length;i++) {
            test[i] = Math.random();
        }
        return test;
    }
}
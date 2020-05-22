double[] a = new double[10];
double[] b = new double[10];
// fill data
int length = a.length;
Integer[] indexes = new Integer[length];
for (int i = 0; i < length; ++i)
    indexes[i] = i;
Arrays.sort(indexes, new Comparator<Integer>() {
    @Override public int compare(Integer o1, Integer o2) {
        return Double.compare(a[o1] / b[o1], a[o2] / b[o2]);
    }
});
double[] sortedA = new double[length];
double[] sortedB = new double[length];
for (int i = 0; i < length; ++i) {
    sortedA[i] = a[indexes[i]];
    sortedB[i] = b[indexes[i]];
}
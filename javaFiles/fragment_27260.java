double[] a = new double[10];
double[] b = new double[10];
// fill data to a and b.
int[] indexes = IntStream.range(0, a.length)
    .boxed()
    .sorted((i, j) -> Double.compare(a[i] / b[i], a[j] / b[j]))
    .mapToInt(i -> i)
    .toArray();
double[] sortedA = IntStream.of(indexes)
    .mapToDouble(i -> a[i])
    .toArray();
double[] sortedB = IntStream.of(indexes)
    .mapToDouble(i -> b[i])
    .toArray();
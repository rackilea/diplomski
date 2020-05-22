double[] distCent = {0.34, 0.12, 0.01, 0.45, 0.65, 0.78};
String[] names = {"Smallest", "2nd smallest", "3rd smallest", "4th smallest", "5th smallest"};
int[] c = {0};
IntStream.range(0, distCent.length)
    .mapToObj(n -> new double[]{n, distCent[n]})
    .sorted(Comparator.comparing(a -> a[1]))
    .limit(names.length)
    .forEach(a -> System.out.printf("%s value is at position %d with the value of %.2f%n",
        names[c[0]++], (int)a[0] + 1, a[1]));
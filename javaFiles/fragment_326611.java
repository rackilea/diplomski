public static void main(String[] args) {
    double[][] arr = { { 2.546, 3.664, 2.455 }, { 1.489, 4.458, 3.333 } };
    System.out.println(Arrays.deepToString(arr));
    arr = insertRow(arr, 1, new double[] { 4.222, 2.888, 7.111 });
    System.out.println(Arrays.deepToString(arr));
}
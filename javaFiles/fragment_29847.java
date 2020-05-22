public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    double[] arr = {1, 2, 3, 4, 5, 6};
    Arrays.sort(arr);
    while (sc.hasNext()) {
        double d = sc.nextDouble();
        Arrays.binarySearch(arr, d);
    }
}
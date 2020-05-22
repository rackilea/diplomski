static int[] javaLoops(int a, int b, int n) {
    int[] result = new int[n];
    for (int i = 0, k = 1, e = a + k * b; i < n; ++i, k *= 2, e += k * b)
        result[i] = e;
    return result;
}

public void main(String[] args) {
    System.out.println(Arrays.toString(javaLoops(0, 2, 10)));
    // -> [2, 6, 14, 30, 62, 126, 254, 510, 1022, 2046]
    System.out.println(Arrays.toString(javaLoops(5, 3, 5)));
    // -> [8, 14, 26, 50, 98]
}
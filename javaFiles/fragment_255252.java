static void print(int n, char[] k, char[] A, int h, int c) {
    if (n <= 0) {
        if (c == h)
            System.out.print(String.valueOf(A) + " ");
    } else {
        for (int i = 0; i < k.length; i++) {
            A[n - 1] = k[i];
            int nc = i > 0 ? c + 1 : c;
            print(n - 1, k, A, h, nc);
        }
    }
}

public static void main(String[] args) {
    String k = "01";
    int n = 4;
    int h = 2;
    print(n, k.toCharArray(), new char[n], h, 0);
}
public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int d = n % 10;
    n = n / 10;
    int c = n % 10;
    n = n / 10;
    int b = n % 10;
    n = n / 10;
    int a = n;

    int t;
    for (int i = 0; i < 24; i++) {
        System.out.println(a * 1000 + b * 100 + c * 10 + d);
        if (i == 11) {
            t = a;
            a = c;
            c = t;
        }
        if (i % 4 == 3) {
            t = a;
            a = b;
            b = t;
        } else {
            t = a;
            a = b;
            b = c;
            c = d;
            d = t;
        }
    }
}
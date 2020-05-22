int a[] = { 2, 6, 12, 20, 30, 42 };

int[] previous = a;
for (int x = a.length - 1; x > 0; x--) {
    int c[] = new int[x];
    for (int y = 0; y < x; y++) {
        c[y] = previous[y + 1] - previous[y];
        System.out.print(c[y] + " ");
    }
    previous = c;
    System.out.println();
}
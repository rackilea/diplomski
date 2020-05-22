public static void nextPermutationArray(int[] v) {
    int x = 1; // changed this line
    int y = 0;
    Random r = new Random();

    while (x < v.length) {

        y = x + r.nextInt(v.length - x);

        int temp = v[x];
        v[x] = v[y];
        v[y] = temp;

        x++;
    }
}
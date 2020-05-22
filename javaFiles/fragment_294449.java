public static int[] addBin(int[] c, int[] d) {
    int[] added = new int[8];
    int remain = 0;
    for (int x = added.length - 1; x >= 0; x--) {
        added[x] = (c[x] + d[x] + remain) % 2;
        remain = (c[x] + d[x] + remain) / 2;
    }
    if (remain!=0) {

        System.out.println("Error: overflow");
    }
    return added;
}
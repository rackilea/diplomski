final int N = temporary.size();
int[][] a = new int[N][];
for (int i = 0; i < N; ++i) {
    final ArrayList<Integer> item = temporary.get(i);
    final int M = item.size();
    a[i] = new int[M];
    for (int j = 0; j < M; ++j) {
        a[i][j] = item.get(j); // assumes no null elements!
    }
}
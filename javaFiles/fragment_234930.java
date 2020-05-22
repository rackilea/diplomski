Future<Integer> futures[][] = new Future[n][n];

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        future = executor.submit(new NaiveMatMul(n, a, b, i, j));
        futures[i][j] = future;
    }
}

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        c[i][j] = futures[i][j].get();
    }
}
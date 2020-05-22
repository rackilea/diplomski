int[] a = new int[n][m];

for (int i = 0; i < n-1; ++i) {
  a[i][m-1] = 1;
}

for (int j = 0; i < m-1; ++j) {
  a[n-1][j] = 1;
}


for (int i = n-2; i >= 0; --i) {
  for (int j = m-2; j >= 0; --j) {
    a[i][j] = a[i+1][j] + a[i][j+1];
  }
}

System.out.print(a[0][0]);
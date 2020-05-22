A = new int[N+1]
for (int p : P) {
  for (int q : P) {
      if (p*q > N || q > p) break;
      A[p*q] = 1
  }
}

for (int i = 1; i <= N; i++)
    A[i] += A[i-1]
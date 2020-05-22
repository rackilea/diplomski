int[] leftMaxes = new int[A.length - 1];
int[] rightMaxes = new int[A.length - 1];

leftMaxes[0] = A[0];
for (int i = 1; i < A.length - 1; ++i) {
  leftMaxes[i] = Math.max(leftMaxes[i-1], A[i]);
}

rightMaxes[A.length - 2] = A[A.length - 1];
for (int i = A.length - 3; i >= 0; --i) {
  rightMaxes[i] = Math.max(rightMaxes[i+1], A[i+1]);
}

for (int i = 0; i < A.length - 1; ++i) {
  System.out.printf("%d: %d %d%n", i, leftMaxes[i], rightMaxes[i]);
}
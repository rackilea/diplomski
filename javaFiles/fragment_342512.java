int[] test = new int[] {numberOne, numberTwo, etc...};
Arrays.sort(test);
for (int i = 0; i < test.length - 1; i++) {
  if (test[i] + 1 != test[i + 1]) {
    // Not sequential
  }
}
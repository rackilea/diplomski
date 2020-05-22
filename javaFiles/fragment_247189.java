for (int i = 0; i < array.length; i++) {
  for (int j = 0; j <= i; j++) {
    int x = random.nextInt(101);
    array[i][j] = x;
    if (i != j) {
      array[j][i] = x;
    }
  }
}
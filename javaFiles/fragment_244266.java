public int[] findEvens() {
  int numberEvens = 0;
  for (int i = 0; i < numbers.length; i++) {
     if (i % 2 == 0) {
        numberEvens++;
     }
  }
int rows = 5;
  int cols = 10;
  int textNumber = 0;
  for (int i = 0; i < rows * cols; i++) {
     if ((i / cols ) % 2 == 0) {
        textNumber = i;
     } else {
        textNumber = ((i / cols) + 1) * cols - (i % cols) - 1;
     }
     textNumber++;
     System.out.printf("[%02d, %02d] ", i, textNumber);
     if ((i + 1) % cols == 0) {
        System.out.println();
     }
  }
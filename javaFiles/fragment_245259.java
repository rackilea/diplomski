int baseWidth = 10;


for (int a = baseWidth ; a > 0 ; a--) {
  for (int b = 0 ; b < a - 1 ; b++) {
    System.out.print(" ");
  }

  for (int b = a - 1 ; b < baseWidth - (a - 1) ; b++) {
    System.out.print("X");
  }

  System.out.print("\n");
}
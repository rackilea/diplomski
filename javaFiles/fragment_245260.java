int baseWidth = 9;


for (int a = baseWidth ; a > 0 ; a--) {
  for (int b = 0 ; b < baseWidth - (a - 1) ; b++) {
    if (b < a - 1) {
      System.out.print(" ");
    }

    if (b >= a - 1 && b < baseWidth - (a - 1)) {
        System.out.print("X");
    }
  }

  System.out.print("\n");
}
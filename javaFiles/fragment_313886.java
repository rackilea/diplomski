private void verticalLine() {
    for (int i = 0; i <= 9; i++) {

      if (i % 3 == 0) {
        System.out.print("|");

      } else {
        System.out.print(" ");
      }
    }
    System.out.println("");
  }

  private void horizontalLine() {
    for (int i = 0; i <= 9; i++) {

      if (i % 3 == 0) {
        System.out.print("+");
      }

      else {
        System.out.print("-");
      }
    }

    System.out.print("\n");
  }
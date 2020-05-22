public static int Dice() {
  return (int)(Math.random() * 6.0) + 1;
}

public static void main(String[] args) {

  // initialize variables to be updated in the loop
  int trials = 0;
  Boolean lastTimeD1WasGreater = false;

  for (int i = 0; i < 100000; i++) {
    // always increment the counter!
    trials++;

    // you had the wrong variable names here.
    // also they must be INSIDE the loop or else they would always come out the same
    int d1 = Dice();
    int d2 = Dice();

    if (d1 > d2) {
      if (lastTimeD1WasGreater) {
        // if it was greater both last time and this time then we're done!
        System.out.println("it took " + trials + " trials.");
        break;
      } else {
        // otherwise set this variable so we can be on the lookout next time.
        lastTimeD1WasGreater = true;
      }
    } else {
      // d1 was not greater, so we'll start looking for a pair in the next loop.
      lastTimeD1WasGreater = false;
    }
  }
}
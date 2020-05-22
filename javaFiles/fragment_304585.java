public static int prüfung() {
while (true) {

    try {
    int ZahlPrüfen = IntervallScanner.nextInt();
    if (ZahlPrüfen > 0) {
        return ZahlPrüfen;

    } else {
        System.out.println("Bitte Geben Sie eine Positive Zahl ein");
    }

  } catch (InputMismatchException e) {
      System.out.println("Bitte Geben Sie eine Zahl und keinen Buchstaben ein");
        IntervallScanner.next();
    }
  }
}
public static int prüfung(int ZahlPrüfen) {
  while (true) {
    try {

        int ZahlPrüfen = IntervallScanner.nextInt();
        if (IntervallScanner.hasNextInt() && ZahlPrüfen > 0) {
            return ZahlPrüfen;

        } else if (ZahlPrüfen <= 0) {
            System.out.println("Bitte Geben Sie eine Positive Zahl ein");
            IntervallScanner.next();
        }

    } catch (InputMismatchException e) {
        System.out.println("Bitte Geben Sie eine Zahl und keinen Buchstaben ein");
        IntervallScanner.next();

    }
}
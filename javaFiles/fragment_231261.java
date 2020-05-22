public static boolean hasFourOfaKind(String hand) {
    int counter = 0;
    for (int i = 0; i < hand.length(); i++) {
        counter = 0;
        for (int j = 0; j < hand.length(); j++) {
            if (hand.charAt(j) == hand.charAt(i)) {
                counter++;
            }
        }
        if (counter >= 4) {
            return true;
        }
    }
    return false;
}
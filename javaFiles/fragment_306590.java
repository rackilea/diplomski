public static void main(String args[]) {
    String suits[] = new String[] {"Clubs", "Diamonds", "Spades", "Hearts"};
    String faces[] = new String[] {"Ace", "King", "Queen", "Jack"};
    String deck[][] = new String[suits.length * faces.length][2];

    int i=0;

    for (String suit : suits) {
        for (String face : faces) {
            deck[i][0] = suit;
            deck[i][1] = face;
            i++;
        }
    }
}
ArrayList<String> deck = new ArrayList<String>();

String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King", "Ace" };

for (int a=0; a < rank.length; a++) {
    for (int b=0; b < suit.length; b++){
        deck.add(rank[a] +" of "+ suit[b]);
    }
}

Collections.shuffle(deck, new SecureRandom());
String randomCard = deck.get(0);
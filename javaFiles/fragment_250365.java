Random rand = new Random();

final int NUMBER_OF_VALUES = Card.CardValue.values().length;
final int NUMBER_OF_SUITS = Card.CardSuit.values().length;
final int NUMBER_OF_CARDS_IN_HAND = 5;
Card.CardValue value;
Card.CardSuit suit;
Hand hand;
List<Card> deck = new ArrayList<>();

// Deck creation
for(int i = 0; i < NUMBER_OF_VALUES; i++) {
    for(int j = 0; j <  NUMBER_OF_SUITS; j++)
        deck.add(new Card(Card.CardValue.values()[i], Card.CardSuit.values()[j]));
}

int counter = 0;
final int TOTAL = 100000;

// Simulation
for(int i = 0; i < TOTAL; i++) {
    Collections.shuffle(deck);
    hand = new Hand();
    for(int j = 0; j < NUMBER_OF_CARDS_IN_HAND; j++)
        hand.addCard(deck.get(j));
    if(hand.isOnePair()) counter++;
}

System.out.println("Probability: " + 100 * counter / (double)TOTAL + "%");
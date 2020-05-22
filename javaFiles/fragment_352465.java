public void displayCards(List<ImageView> disp) {

    int cardNumber = 0;
    Set<Card> myCards = new HashMap<Card>();
    for (ImageView c : disp) {

        cardNumber++;

        Card newCard;

        do {
            rank = rand(13) + 2;
            int i = rand(4);
            if (i == 0) {
                suit = 's';
            } else if (i == 1) {
                suit = 'h';
            } else if (i == 2) {
                suit = 'd';
            } else {
                suit = 'c';
            }
            newCard = new Card(rank, suit);
        } while(myCards.contains(newCard));

        myCards.add(newCard);


        if (cardNumber == 1) {
            dc1 = newCard;
        } else if (cardNumber == 2) {
            dc2 = newCard;
        } else if (cardNumber == 3) {
            dc3 = newCard;
        } else if (cardNumber == 4) {
            pc1 = newCard;
        } else if (cardNumber == 5) {
            pc2 = newCard;
        } else {
            pc3 = newCard;
        }
    }
List<Card> cardList = new ArrayList<Card>();
//Put some value in the list.
cardList.add(new Card("Ace","Hearts"));
//And so on..
    for (Card card : cardList) {
        System.out.println("Number = "+card.getNumber()+" Suit = "+card.getSuit());
    }
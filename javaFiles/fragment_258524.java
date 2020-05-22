private Array<Card> cards;

...

public void createDeck(){

   cards = new ArrayList<Card>();

   cards.add(new Card("Name1", 1, 2, 3, 4));
   cards.add(new Card("Name2", 5, 6, 7, 8));
   cards.add(new Card("Name3", 9, 10, 11, 12));

}
private Card cards[];

...

public void createDeck(){

   cards = new Card[20];

   cards[0] = new Card("Name1", 1, 2, 3, 4);
   cards[1] = new Card("Name2", 5, 6, 7, 8);
   ...
   cards[19] = new Card("Name20", 50, 60, 70, 80);

}
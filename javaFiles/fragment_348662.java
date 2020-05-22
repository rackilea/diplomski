public ArrayList<String> reverseDeck(ArrayList<String> deckOfCards)
{
   ArrayList<String> reversedDeck = new ArrayList<String>(deckOfCards.size());

   for(int i=deckOfCards.size()-1;i>=0;i--)
       reversedDeck.add(deckOfCards.get(i));

   return reversedDeck;
}
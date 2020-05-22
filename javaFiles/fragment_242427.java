public void addCardToPile(Card card, int pileIndex) {
   while (allPiles.size() < pileIndex) {
       allPiles.add(new Stack<Card>());
   }

   allPiles.get(pileIndex).push(card);
}


public Card getTopCardFromPile(int pileIndex) {
   while (allPiles.size() < pileIndex) {
       allPiles.add(new Stack<Card>());
   }

   if (allPiles.get(pileIndex).isEmpty()) {
       return null;
   }

   return allPiles.get(pileIndex).pop();
}
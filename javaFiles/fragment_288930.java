private void DealCard() {

  if(!deck.isEmpty())
  {
     Card c = deck.removeTopCard();
     onTable.add(c);
     System.out.println(c);
  }
  else 
  {
     //print something to notify user that the decks is empty, or someother form of handling.
  }
}
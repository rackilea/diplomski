public static Card dealCard(Card[] d){
Card[] tempDeck = new Card[d.length-1];
for (int i =0; i<tempDeck.length; i++){
    tempDeck[i] = d[i];
}
Card cardDealed = d[d.length-1];
deck = tempDeck;
return cardDealed;
}
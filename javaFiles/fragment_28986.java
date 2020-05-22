private List<Card> cardList;

public Deckofcards() {
        cardList = Collections.shuffle(Arrays.asList(Cards)); //SHUFFLE
        }

public Card newCard(){
    if(!cardList.isEmpty()){
       return cardList.remove(0);        
    }            
    return null;
}
public Deck(String[] suits, String[] ranks, int[] values){
    ArrayList<Card> cardslist = new ArrayList<Card>();
    for(String suit: suits) {
        for(int i = 0; i < ranks.length; i++) {
            cardslist.add(new Card(suit, ranks[i], values[i]));
        }
    }
    size=cardslist.size();
    cards=cardslist;
}

public List<Card> getDeck(){
    return cards;
}
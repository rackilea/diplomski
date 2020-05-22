int cardValue = -1;

paintComponent(){
    if (cardValue == -1){
        cardValue = drawRandomCard();
    }
    // now paint it.
}
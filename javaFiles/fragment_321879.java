private void perfectShuffle(){
    String[] myDeck = Deck();
    for (int i=0; i<27; i++){
        myDeck[i]=myDeck[i+26];
    }
    for (int i=0; i<52; i++){
        System.out.println(myDeck[i]);
    }
}
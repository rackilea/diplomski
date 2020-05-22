public static void startNewGame()  //use this for reset
{
    ArrayList<Card> deck = createNewDeck();
    ShuffleCards(deck);  
    ResetImages(deck);   //reset card images
    ResetComponents();   //reset all buttons/display to initial state
}
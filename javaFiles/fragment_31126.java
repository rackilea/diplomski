public card deal()
  {
  if ( currentCard < NCARDS  )
     {
        cardsLeft--;
        return ( deckOfCards[ currentCard++ ] );
     }
     else
     {
        System.out.println("Out of cards error");
        return (null);// Error;

     }  
  }
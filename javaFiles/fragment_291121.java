for(int i=0; i< deck.length; i++) //Shuffle
    {
        // this line chooses a random card in the deck
        int count= (int)(Math.random()* deck.length); 
        // this line sets the card at index 'i' to the randomly chosen card
        deck[i] = deck[count];
        // however your creating multiple instance of one card in the deck
        // instead of switching the cards around, this will lead to your deck
        // having more than one of the same card.
    }
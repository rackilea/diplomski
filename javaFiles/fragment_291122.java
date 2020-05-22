for(int i=0; i< deck.length; i++) //Shuffle
    {
        // create a temporary card to hold the value of the card to switch
        Card tmp = deck[i];
        // now choose a random card in the deck
        int count= (int)(Math.random()* deck.length); 
        // now set the card at index 'i' to the randomly chosen card
        deck[i] = deck[count];
        // and set the randomly chosen card to deck[i]
        deck[count] = tmp;
    }
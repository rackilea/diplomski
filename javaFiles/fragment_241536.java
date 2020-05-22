try {
        if(deckPosition.hasNext())
        {
            lastDrawn = deckPosition.next();
            return 1;
        }
        else if(cards.isEmpty())
        {
            emptyDeck();
            return 0;
        }
        else
        {
            // throw new EndOfDeckException();  // Don't throw it
            return endOfDeck();
        }

    } catch(Exception e) {
        /** Also, if possible, replace this catch block with the one catching
            more specific exception than all the `Exceptions` **/
        System.out.println("Exception when drawing a card, check try/catch block in draw() method of Card");
        throw new RuntimeException("Exception drawing a card");
    }
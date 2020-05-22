public boolean chooseHigh() {
        nextCard = deck.dealCard();

            if(nextCard.getCardIntValue() > currentCard.getCardIntValue()) {
                    correctGuesses++;
                    gameOver = false;
            }
            else {
                gameOver = true;
            }
        currentCard = nextCard;
        return gameOver;
    }
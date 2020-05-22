int cardsSelected = 0;
int hand = 0;
// select first card not to be in the hand
for(int firstCard = 0; firstCard < 7; firstCard++){
    // select first card not to be in the hand
    for(int secondCard = firstCard + 1; secondCard < 7; secondCard++){
        // every card that is not the first or second will added to the hand
        for(int i = 0; i < 7; i++){
            if(i != firstCard && i != secondCard){
                allHands[hand][cardsSelected++] = allCards[i];
            }
        }
        // next hand
        cardsSelected = 0;
        hand++;
    }
}
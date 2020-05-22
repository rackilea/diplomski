if( gameState[tappedCounter] == 2){
    gameState[tappedCounter] = activePlayer;
    if(activePlayer==0){
         activePlayer = 1;}
    else{
        activePlayer =0;
    }
}
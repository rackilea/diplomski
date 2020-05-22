if(lastTouched <= 0){
    if(atLeastOneTouched){
        GameOverScreen(game,score,true); // game over complete
    }else{
        GameOverScreen(game,score,false); // game over failed
    }
}
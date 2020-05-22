for(int i = 0; i < 100000; i++){
 int diceResult = d.throwDice(diceCount); // call it with your "diceCount"
                                          // variable
  if(diceResult == diceScore){ // don't call "throwDice()" again here
    scoreCount += 1;
  }
}
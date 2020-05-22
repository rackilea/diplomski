Player(boolean isAttacker){
    armees = 10;
    // if object name is Attacker, tarninger = 3, if defender = 2
    int diceNum;
    if (isAttacker) diceNum = 2;
    else diceNum = 3;
    Dices= new Dice[diceNum];
    for(int i=0;i<Dices.length;i++){
        Dices[i]=new Dice();
    }
}
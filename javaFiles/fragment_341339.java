for (int i = 0; i < this.DiceCount; i++) {

         if(i < (this.DiceCount-1) &&  diceRolls[i] != diceRolls[i+1] ){
            return false;
        }
    }
    return true; 
}
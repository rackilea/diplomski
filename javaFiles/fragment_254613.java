public int[] RollDice(ImageButton [] dice, int [] diceValue, boolean [] isHeld, Random rand)
{
    for (int i = 0; i < dice.length; i++) {
        if (!isHeld[i]) {
            int rndInt = rand.nextInt(6) + 1; // Random number between 1 and 6          
            String imgName = "die" + rndInt;                    
            int id = getResources().getIdentifier(imgName, "drawable", getPackageName());   
            diceValue[i] = rndInt;
            dice[i].setImageResource(id);  //Loops through the dice array and sets the appropriate dice images based on individual randoms
        } else {
            //do nothing                        
        }
    }

    rollNum ++;
    if(rollNum >= MAX_ROLLS){
        //Turn is over
        turnNum ++;
        ScoreDice();
    else {
        roll.setText("Roll (" + (MAX_ROLLS - rollNum) + " Remaining)");
    }

    return diceValue;
}
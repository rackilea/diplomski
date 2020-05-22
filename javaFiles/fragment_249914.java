public String guessloc(int guessnum) {
    for(int i=0;i<battleship.length;++i) {
        if(battleship[i] == guessnum) { //it's a hit
            battleship[i] = -1; //you cant hit it again, so change it
            if(++numofhits == 3) {
                return "kill";
            }else
                return "hit";
            }
    }
    return "miss"; //miss should be outside of the for loop
}
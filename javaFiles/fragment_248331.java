/**Checks if player X or O won **/
    public boolean isWinner(Button[] buttons){
                return playerWins(buttons, 'X') || playerWins(buttons, 'O');
    }

/**Checks if a player has 3 buttons aligned **/
    private boolean playerWins(Button[] buttons, char player) {
        return lineWin(buttons,player,0,1,2) ||
                lineWin(buttons,player,0,3,6) ||
                lineWin(buttons,player,3,4,5); //TODO add the 5 others conditions       
    }

/** Checks if the buttons at i,j and k belongs the player **/
    private boolean buttonsBelongToPlayer(Button[] buttons, char player, int i, int j, int k) {
        return buttons[i].getText()==player && buttons[j].getText()==player && buttons[k].getText()==player;
    }
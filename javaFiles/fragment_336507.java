public boolean checkIsSelectablePlayerByRound(Player player, Round round){
    for(Game game : gamesByRound.get(round)){
        if(game.playerOne == player || game.playerTwo == player){
            return false;
        }
    }
    return true;
}
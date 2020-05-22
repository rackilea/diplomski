if(checkWin(gameboard, possibilities)){
        bigWinner();
        return true;
}
//loop through and look for tie
for(int x = 0; x< gameboard.length; x++){
    if(gameboard[x] != 'O' && gameboard[x] != 'X'){
        return false;
    }
}
System.out.println("Tie Game.");
return true;
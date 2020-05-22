if (checkingBoard[row][column] == player
        && checkingBoard[row][column += 1] == player
        && checkingBoard[row][column += 1] == player
        && checkingBoard[row][column += 1] == player) {

    return player;
}

else if (checkingBoard[row][column] == player
        && checkingBoard[row][column -= 1] == player
        && checkingBoard[row][column -= 1] == player
        && checkingBoard[row][column -= 1] == player) {

    return player;
}
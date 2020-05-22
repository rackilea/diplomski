for (int[] indices: winPossibilities) {
    if (gameBoard[i[0]] == gameBoard[i[1]] && gameBoard[i[1]] == gameBoard[i[2]]) {
        return true;
    }
}
return false;
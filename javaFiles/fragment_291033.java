if(ship1[i][0] == userInput[0] && ship1[i][1] == userInput[1]) {
    board[userInput[0]][userInput[1]] = "|!";
    if(userInput[1] == 7) {
        board[userInput[0]][userInput[1]] = "|!|";
    }
    break; // that's it!
}
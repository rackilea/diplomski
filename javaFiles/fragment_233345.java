if (board[row][column] == 'X') {
    count_piece++;
    if(count_piece == 4) {
        System.out.println("you win");
        return;
    }
} else {
    count_piece = 0;
}
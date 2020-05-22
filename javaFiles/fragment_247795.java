public boolean checkWin(char badge) {
    return checkHorizontalStreaks(board, badge)
            || checkVerticalStreaks(board, badge);
}

private boolean checkHorizontalStreaks(char[][] board, char badge) {
    for (int row = 0; row < board.length; row++) {
        // loop throught each row
        int currentStreak = 0;
        for (int col = 0; col < board[row].length; col++) {
            // loop through each column in the row
            if (board[row][col] == badge) {
                // keep the streak of 'badge' going
                currentStreak++;
                if (currentStreak == 4) {
                    // winner
                    return true;
                }
            } else {
                // restart the streak
                currentStreak = 0;
            }
        }
    }
    return false;
}
if(board[startX][startY] == null) {
    return false;
}

Player player = board[startX][startY].getTeam()
int xOffset = player == Player.UP
    ? 1
    : -1;
//If a Piece exists on a diagonally adjacent tile, return true
if(endX - startX == xOffset && Math.abs(startY - endY) == 1) {
    if( (board[startX + xOffset][startY - 1] != null && board[startX + xOffset][startY - 1].getTeam() != player) || 
            (board[startX + xOffset][startY + 1] != null && board[startX + xOffset][startY + 1].getTeam() != player)) {
        return true;
    }
}
if (!gameOver())
{
    if(!rw.board.possibleMoves(rw.board.turn).isEmpty())
    {
        // needs to wait until the player makes a move
        Move m =  rw.players[rw.board.turn].move;
        rw.board.makeMove(m);
        rw.updateNewGame();
    }
    // switch the turns after the move
    rw.players[rw.board.turn].move = null;
    rw.board.turn = (rw.board.turn == PLAYER1 ? PLAYER2 : PLAYER1);
}
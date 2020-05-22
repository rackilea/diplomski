for(Move move: possibleMoves){
    Square landing = move.getLanding();
    int landingX = move.getLandingXC();
    int landingY = move.getLandingYC();
    int score = scoring(enemyPiece.pieceName());
    if(score > highestWeight){
        highestWeight = score;
        best = move;
    }
}
return best;
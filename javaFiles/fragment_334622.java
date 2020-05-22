public int doGame( Labels labels)
{
    labels = "         ";
    int itisXmove = true;              // player X or O turn
    for( int movesLeft = 9; movesLeft > 0; movesLeft --)
    {
        int position =          // 0 .. movesLeft-1
                (int) Math.floor(Math.random() * movesLeft);

        for( int pos = 0; pos < 9; pos ++)        // find position
            if( labels[ pos] == " ")              // unused pos?
                if( position-- == 0)              // countdown
                {
                    if( itisXmove)                // use the pos
                        labels[ pos] = "X";       // for current player
                    else
                        labels[ pos] = "O";
                    break;
                }

        int result = checkWinner( labels);        // who wins (non-zero)?
        if( result != 0)
            return result;

        itisXmove = ! itisXmove;                  // next turn
    }
    return 0;                                     // a tie
}
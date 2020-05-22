if (bowlingArray[0][0] == 10) {
        score1 = 10 + bowlingArray[0][1] + bowlingArray[1][1];
    }
    if (bowlingArray[0][0] + bowlingArray[1][0] == 10) {
        score1 = 10 + bowlingArray[0][1];
    } else
        score1 = bowlingArray[0][0] + bowlingArray[1][0];
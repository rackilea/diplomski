public static int[] makeAMove(char move) {

    int[] finalMove = new int[2];
    if (move == 'w') {
        finalMove[1] = -1;
    }
    else if (move == 'a') {
        finalMove[0] = -1;
    }
    else if (move == 's') {
        finalMove[1] = 1;
    }
    else if (move == 'd') {
        finalMove[0] = 1;
    }
    return finalMove;
}
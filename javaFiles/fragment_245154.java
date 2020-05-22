for (int i = 0; i < amt; i++) {
    if (board2[i] == 0) { //if the space is empty
        moves[count] = i;// appends the index of the next empty space to the moves array
        count++;
    }
}
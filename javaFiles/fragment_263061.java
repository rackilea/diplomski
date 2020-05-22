if (getPlays(state, player) > getPlays(state, opponent))
    state[r][c] = opponent; //Puts opponent in current spot if player has played more times than opponent
else
    state[r][c] = player; //Puts player in current spot if opponent has played more times than player
int best = -10;
for (int column = 0; column < GRID_WIDTH; column++) {
    int row = top(hypothetical, column);
    if (row >= 0) {
        int tmp = minimax(hypothetical, row, column, player);
        if (tmp > best) best = tmp;
    }
}
state[r][c] = null;
return best;
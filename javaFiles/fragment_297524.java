for (int r = lengthsnake; r > 0; r--) {
    if (r == 0) {
        snakeXlength[r] = snakeXlength[r] + 25;
    } else {
        snakeXlength[r] = snakeXlength[r - 1];
    }

    if (snakeXlength[r] > 850) {
        snakeXlength[r] = 25;
    }
}
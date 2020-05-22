for (int r = lengthsnake; r > 0; r--) {
    snakeXlength[r] = snakeXlength[r - 1];

    if (snakeXlength[r] > 850) {
        snakeXlength[r] = 25;
    }
}
snakeXlength[0] = snakeXlength[0] + 25;
if (snakeXlength[0] > 850) {
    snakeXlength[0] = 25;
}
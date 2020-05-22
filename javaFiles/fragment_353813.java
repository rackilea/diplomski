int counter = 0;
while(counter < NUMBER_OF_TARGETS){
    int randRow = random.nextInt(ROWS - 1);
    int randColumn = random.nextInt(COLUMNS - 1);
    if (grid[randRow][randColumn] == null) {
        grid[randRow][randColumn] = "X";
        ++ counter;
    }
}
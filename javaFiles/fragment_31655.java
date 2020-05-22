for(int column = 0; column < columns; column++)
{
    char index = condensed[i];
    fillThemLetters[row][column] = index;
    i++; // <--------- THIS IS WRONG!!!
}
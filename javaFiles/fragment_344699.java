for(int i = 0; i < ROWS; i++)
{
    for(int j = 0; j < COLUMNS; j++)
    {
        if(seatingArray[i][j] == price)
        {
            matchedSeats[i][j] = price;
        }
    }
}
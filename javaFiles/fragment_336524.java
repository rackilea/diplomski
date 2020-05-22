for(int i = 0; i < 9; i++)
{   
    for(int j = 0; j < 10; j++)
    {
        // I've used a default Seat() constructor to create the object, in your actual case, it may differ.
        seatArray[i][j] = new Seat(); // Initializing each array element with a new Seat object
        seatArray[i][j].cost=prices[i][j];
    }
}
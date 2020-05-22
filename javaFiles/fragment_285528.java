public void setArray()
{
    //Use the global variable and don't create a local one
    this.towers = new player[30];
    for(int i = 0; i < 30; i++)
    {
        towers[i] = new player(5,5);
    }
}
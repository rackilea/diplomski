public void addItem(Item item, int limit) 
{ 
    ArrayList<Cell> passages = new ArrayList<Cell>();

    for(int x = 0;  x < cells.length; x++) 
    { 
        for (int y = 0; y < cells[w].length; y++) 
        { 
            if (cells[x][y] == "P") //if it's a passage
                passages.add(new Cell(x,y)); 
        } 
    } 


    Random rand = new Random();
    while(spawnedItems < limit){

        if(passages.size() == 0)
            throw LimitImpossibleError();

        int randomNum = rand.nextInt(passages.size());

        items.add(new ItemPosition(item, passages.get(randomNum))); //assuming that you have a global ArrayList of Item and respective Cell (ItemPosition) to draw them later 
    }
}
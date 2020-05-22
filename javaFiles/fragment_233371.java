class Room{  //can be declared as abstract
    int cost;
    public int getCost(){return cost;}
}

class largeRoom extends Room{
    //inherit cost from Room class
}

class smallRoom extends Room{
    //inherit cost from Room class    
}
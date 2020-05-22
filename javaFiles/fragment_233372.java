public Room mostExpensive(ArrayList<Room> allRooms)
{
    Room mostExpensiveRoom;  
    int max = 0;
    for(int x=0; x<allRooms.size(); x++)
        if(allRooms.get(x).getCost() > max){
            mostExpensiveRoom = allRooms.get(x);
            max = allRooms.get(x).getCost();}
    return  mostExpensiveRoom;
}
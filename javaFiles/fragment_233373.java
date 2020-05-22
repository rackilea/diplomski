public static void main(String[] args){
    List<Room> allRooms = new ArrayList<Room>();
    allRooms.add(new smallRoom());
    allRooms.add(new largeRoom());

    Room mostExpensiveRoom = mostExpensive(allRooms);
}
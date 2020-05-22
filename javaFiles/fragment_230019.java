protected int FindPlayer(int theID){
    if (playerObjects.size() != 0){
        for (int i = 0; i < playerObjects.size(); i++){
            Person player = (Person) playerObjects.get(i);
            if (player.getID() == theID){
                return i;
            }
        }

        System.out.println("Player with ID # " + theID + " not found");
    } else {
        System.out.println("No players have been added.");    
    }

    return -1;
}
public void RemovePlayer(int theID){
    int playerId = FindPlayer(theID);
    if (playerId >= 0) {
        playerObjects.remove(playerId);
    }
}

public void RetrievePlayer(int theID){
    int playerId = FindPlayer(theID);
    if (playerId >= 0) {
        Person player = (Person) playerObjects.get(playerId);
        player.getDetails();
    }
}
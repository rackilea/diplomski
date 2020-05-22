public boolean isUserAvailable(String potentialOpponent) throws RemoteException {
    for (Entry<Player, Game> entry : this.gameList.entrySet()) {
        if (entry.getKey().getUsername().equals(potentialOpponent)) {
            return false;
        }
    }
    return true;
}
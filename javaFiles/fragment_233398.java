int wantedCount = 5;

Iterator<Player> itr = event.iterator();
while (event.getNumPlayers() > wantedCount) {
    itr.next();
    itr.remove();
}
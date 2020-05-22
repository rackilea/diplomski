public void run() {
    if (!isLoading && !playerList.isEmpty()) {
        this.isLoading = true;
        ArrayList<Player> clonedList = (ArrayList<Player>)playerList.clone();
        playerList.clear();
        try {
            for (Player player : clonedList) {
                main.getDataManager().loadPlayer(player);
            }
        } catch (Exception e) { }
        this.isLoading = false;
    }
}
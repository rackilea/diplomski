public void run() {
    if (!isLoading && !playerList.isEmpty()) {
        this.isLoading = true;
        ArrayList<Player> clonedList = (ArrayList<Player>)playerList.clone();
        playerList.clear();
        for (Player player : clonedList) {
            try {
                main.getDataManager().loadPlayer(player);
            } catch (Exception e) { }
        }
        this.isLoading = false;
    }
}
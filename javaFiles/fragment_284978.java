BasketballPlayer player1 = new BasketballPlayer("Smith", 2.02);
BasketballPlayer player2 = new BasketballPlayer("Jones", 1.95);

List<BasketballPlayer> playersByHeight = new ArrayList<BasketballPlayer>();
List<BasketballPlayer> playersByName = new ArrayList<BasketballPlayer>();
playersByHeight.add(player1);
playersByHeight.add(player2);
playersByName.add(player1);
playersByName.add(player2);

Collections.sort(playersByName, new Comparator<BasketballPlayer>() {
    @Override
    public int compare(BasketballPlayer o1, BasketballPlayer o2) {
        return o1.getName().compareTo(o2.getName());
    }
});
Collections.sort(playersByHeight, new Comparator<BasketballPlayer>() {
    @Override
    public int compare(BasketballPlayer o1, BasketballPlayer o2) {
        return o1.getHeight().compareTo(o2.getHeight());
    }
});
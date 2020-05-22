@OneToMany(cascade = { CascadeType.ALL })
private List<Player> players = new ArrayList<Player>();

public void addPlayer(Player player) {
    player.setTeam(this);
    players.add(player);
}

public Collection<Player> getPlayers() {
    return new ArrayList<Player>(this.players);
}
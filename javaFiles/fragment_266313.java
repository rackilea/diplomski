@GET
@Path("/players")
public List<Player> getPlayers(){
    List<Player> players = getPlayersFromHibernate();

    for(Player player : players)
        player.setPosition(null);

    return players;
}
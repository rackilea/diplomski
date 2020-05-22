private void mod() {
    Player p = playersService.loadById(1L);
    p.setNick("OtherNick");
    playerService.updatePlayer(p);
}

Then in PlayerService

@Transactional
public void updatePlayer(Player player){
   session.merge(player);
}
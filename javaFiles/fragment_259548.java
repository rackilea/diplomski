@EventHandler
public void playerMoves(PlayerMoveEvent e) {
    Player p = e.getPlayer();

    //Check if the player moved to a new block
    if (e.getTo().getBlockX() != e.getFrom().getBlockX() || e.getTo().getBlockY() != e.getFrom().getBlockY() || e.getTo().getBlockZ() != e.getFrom().getBlockZ()) {
        //If they have, set their value in the hashmap to true
        getter.hasMoved.put(p.getName(), true);
    }
}
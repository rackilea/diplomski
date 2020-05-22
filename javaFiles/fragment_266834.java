@EventHandler
public void onRespawnPVPEVENT(PlayerRespawnEvent pvpevent) {
    Player p = pvpevent.getPlayer();
    double x = 22;
    double y = 82;
    double z = 22;
    Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
    pvpevent.setRespawnLocation(loc);
}
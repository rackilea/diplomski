@EventHandler
public void onPlayerRespawn(PlayerRespawnEvent event) {
    FileConfiguration config = getConfig(); //Or whichever method you are using
    World world = Bukkit.getWorld(config.getString("world"));
    double x = config.getDouble("x");
    double y = config.getDouble("y");
    double z = config.getDouble("z");
    float yaw = (float) config.getDouble("yaw");
    float pitch = (float) config.getDouble("pitch");
    event.setRespawnLocation(new Location(world, x, y, z, yaw, pitch));
}
@EventHandler
public void onPlayerJoinEvent(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    FileConfiguration cfg = plugin.getConfig();

    // get all enabled locations
    List<String> locations = plugin.getLocationList().stream().
        filter(s -> !cfg.getBoolean("locations." + s + ".disabled")).
        collect(Collectors.toList());
    if (locations.size() === 0) {
        // TODO: handle this special case
    }

    // teleport to random location
    String randomString = plugin.getRandomStringFromList(locations);
    String cfgPrefix = "locations." + randomString + ".";
    p.teleport(new Location(
        Bukkit.getWorld(cfg.getString(cfgPrefix + "world")),
        cfg.getDouble(cfgPrefix + "x"),
        cfg.getDouble(cfgPrefix + "y"),
        cfg.getDouble(cfgPrefix + "z"),
        cfg.getInt(cfgPrefix + "yaw"),
        cfg.getInt(cfgPrefix + "pitch")));
}
@EventHandler
public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    File file = new File(getDataFolder() + "/UserData/" + player.getUniqueId() + ".yml"); //Assuming all required directories exist
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Bukkit.getServer().getLogger().info("[Morph] Creating new user file " + player.getUniqueId() + "for user " + player.getName());
        FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
        fileConfig.createSection("Mobs");
        List<String> ListOfStrings = Arrays.asList("mob1", "mob2", "mob3");
        fileConfig.set("Mobs", ListOfStrings);
        try {
            fileConfig.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
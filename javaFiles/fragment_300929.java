public class MainListener implements Listener {

    private Main plugin;

    public MainListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        FileConfiguration config = plugin.getConfig();
    }
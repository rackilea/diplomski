public class Demo extends JavaPlugin {
    public void onEnable() {
        Bukkit.getScheduler.scheduleMyEpicCooldown(new CoolDown(this, time), time);
    }
}


public class CoolDown extends BukkitRunnable {
    private final Demo plugin;
    private int time;

    public CoolDown(Demo plugin, int time) {
        this.plugin = plugin;
        this.time = time;
    } 

    public void run() {
        plugin.fooBar();
    }
}
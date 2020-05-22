public class Winner extends BukkitRunnable {
    private Player player;
    public Winner(Player player) {
        this.player = player;
    }
    @Override
    public void run() {
        Location spawn = player.getWorld().getSpawnLocation();
        player.teleport(spawn);
    }
}
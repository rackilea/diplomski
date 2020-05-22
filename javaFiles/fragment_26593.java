public class ExampleMod extends JavaPlugin {
    private EntityHider entityHider;

    private static final int TICKS_PER_SECOND = 20;

    @Override
    public void onEnable() {
        entityHider = new EntityHider(this, Policy.BLACKLIST);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            final Sheep sheep = player.getWorld().spawn(player.getLocation(), Sheep.class);

            // Show a particular entity
            entityHider.toggleEntity(player, sheep);

            getServer().getScheduler().scheduleSyncDelayedTask(this, new         Runnable() {
                @Override
                public void run() {
                    entityHider.toggleEntity(player, sheep);
                }
            }, 10 * TICKS_PER_SECOND);
        }
        return true;
    }
}
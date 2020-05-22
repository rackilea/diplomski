@EventHandler
public void onEntityShootBow(EntityShootBowEvent event) {
    if (event.getProjectile() instanceof Arrow) { // If the projectile shot is actually an arrow
        // Add your own conditions here ... such as the name of the bow etc.
        Arrow arrow = (Arrow) event.getProjectile(); // Cast
        // Create the LightningArrowTask BukkitRunnable with the arrow object, run it repeatedly every tick (with a 0 tick delay)
        new LightningArrowTask(arrow).runTaskTimer(this, 0, 1);
        // If you'd like the lightning to only be spawned every 2, 3, 5 etc. ticks, just change that last argument of the runTaskTimer method
    }
}
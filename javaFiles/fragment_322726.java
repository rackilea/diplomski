public class LightningArrowTask extends BukkitRunnable {

    private Arrow arrow; // The arrow to spawn lightning at
    private int tick = 0; // The number of times the run() method has been invoked

    // The constructor that asks for an arrow entity
    public LightningArrowTask(Arrow arrow) {
        this.arrow = arrow;
    }

    @Override
    public void run() {
        // If the arrow no longer exists, has landed, or this task has been running for more than ~10 seconds (200 ticks)
        if (arrow == null || arrow.isOnGround() || tick++ > 20 * 10) {
            this.cancel(); // Cancel the task
        } else {
            arrow.getWorld().strikeLightning(arrow.getLocation()); // Otherwise, make lightning strike at the arrow's location
        }
    }
}
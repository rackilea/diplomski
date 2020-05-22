@EventHandler
public void onPlayerInteractEntity (PlayerInteractEntityEvent event) {
    Entity entity = event.getRightClicked();
    Player player = event.getPlayer();

    float pitch = player.getLocation().getPitch();
    float yaw = player.getLocation().getYaw();

    if (entity instanceof AbstractHorse) {
        event.setCancelled(true);

        Location loc = player.getLocation();
        loc.setPitch(pitch);
        loc.setYaw(yaw);
        player.teleport(loc);

        AbstractHorse horse = (AbstractHorse) event.getRightClicked();
        player.sendMessage(horse.getName());
    }
}
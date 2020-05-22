@EventHandler
public void playerDamagesWhenToggledOff(EntityDamageByEntityEvent e) {
    if (e.getEntity() instanceof Player) { // If damaged entity is a player
        Player victim = (Player) e.getEntity(); // Cast
        if (e.getDamager() instanceof Player) { // If the damager is also a player
            Player damager = (Player) e.getDamager();
            // Check if either of them are in the list, if so -> cancel damage
            if (getter.noPVP.contains(victim.getName()) || getter.noPVP.contains(damager.getName())) {
                e.setCancelled(true);
            }
        // If the damager was not a player, we can check if it was a projectile using the damage cause
        // Still check whether damaged player is in noPVP list
        } else if (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE && getter.noPVP.contains(victim.getName())) {
            e.setCancelled(true);
        }
    }
}
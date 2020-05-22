@EventHandler
public void onPlayerDamage(EntityDamageEvent event) {
    if(godModed.containsKey(event.getEntity())) {
        event.setCancelled(true);
    }
}
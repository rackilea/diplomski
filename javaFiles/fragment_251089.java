@EventHandler
public void onBlockPlace(BlockPlaceEvent event) {
    Block block = event.getBlock();
    Block against = event.getBlockAgainst();

    if(block.getType().equals(Material.RAIL) && against.getType().equals(Material.SLIME_BLOCK)) {
        event.setCancelled(true);
    }
}
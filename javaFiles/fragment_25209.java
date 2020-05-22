@EventHandler
public void blank(PlayerDropItemEvent e) {
    Player player = e.getPlayer();
    Inventory inventory = player.getInventory();
    player.openInventory(inventory);
}
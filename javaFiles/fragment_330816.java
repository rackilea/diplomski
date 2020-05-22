@SuppressWarnings("deprecation")
@EventHandler
//It's better if you make your events public
//and not private
public void onClick(InventoryClickEvent e) {

if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("[DuelRequest]"))
    return;

Player player = (Player) e.getWhoClicked();
e.setCancelled(true);

//get the UUID stored in the duels HashMap for the player's UUID as a key
UUID uuid = duels.get(player.getUniqueId());

//Get the challenger from the UUID above
Player challenger = Bukkit.getPlayer(uuid);

switch (e.getCurrentItem().getType()) {
case EMERALD_BLOCK:
    player.closeInventory();
    player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.GREEN + " You accepted the request");
    player.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
    player.getInventory().setItem(1, new ItemStack(Material.BOW));
    player.getInventory().setItem(2, new ItemStack(Material.GOLDEN_APPLE, 2));
    player.getInventory().setItem(3, new ItemStack(Material.ARROW, 32));
    player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
    player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
    player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
    player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));

    //give the kit to the challenger here
    //Maybe make a method, giveKit(Player p), to clean up your code
    //Then you could run giveKit(challenger) and giveKit(player)
    break;
case REDSTONE_BLOCK:
    player.closeInventory();
    player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.RED + " You denied the request!");


    //tell the challenger that player denied their duel request
    challenger.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.RED + player.getName + " denied your duel request");
    break;
default:
    player.closeInventory();
    break;
}
}
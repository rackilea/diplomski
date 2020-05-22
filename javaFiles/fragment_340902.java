if(blockMaterial.equals(Material.DIAMOND_ORE)) {
    Bukkit.broadcastMessage(ChatColor.WHITE+player.getDisplayName()+" found a "+ ChatColor.AQUA + ChatColor.BOLD+"Diamond!!!");
    int a = plugin.getConfig().getInt("diamonds."+player.getUniqueId());
    plugin.getConfig().set("diamonds."+player.getUniqueId(), ++a);
    plugin.saveConfig();
}
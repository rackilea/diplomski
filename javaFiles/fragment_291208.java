for (Player player : Bukkit.getOnlinePlayers()) {
    getServer().dispatchCommand(Bukkit.getConsoleSender(), "ban " + player.getName());
    //Alternatively use the method below to ban players
    //Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "insert_reason_here", null, sender.getName());
    //player.kickPlayer("Banned by admin");
}
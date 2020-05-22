public boolean onCommand(CommandSender sender, Command cmd, String[] args){
    if(cmd.getName().equalsIgnoreCase("leaving")){
        Player player = (Player) sender;
        Bukkit.broadcastMessage(ChatColor.RED + player.getName() + ChatColor.LIGHT_PURPLE + ChatColor.ITALIC + " is about to leave the server. Please say your goodbyes!");
        Bukkit.getScheduler().runTaskLater(this, new Runnable() {
            public void run() {
               player.kickPlayer(ChatColor.RED + "Kicked:" + ChatColor.WHITE + " You requested to leave.");
            }
        }, 20 * 30);
        return true;
    }
    return false;   
}
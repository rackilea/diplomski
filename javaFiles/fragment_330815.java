if (cmd.getName().equalsIgnoreCase("duel")) {
    if (!(args.length == 1)) {
        sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.RED + " Usage: /duel <Player>");
        return true;
    } else if (args.length == 1) {

        Player p = Bukkit.getServer().getPlayer(args[0]);
        if (p != null) {
            if (p.equals(sender)) {
                sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.RED + " You cannot duel yourself!");
                return true;
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.GREEN + " You sent a duel request to " + ChatColor.BLUE + p.getName());
                p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.GREEN + " You recieved a duel request from " + ChatColor.BLUE + sender.getName());
                openGUI(p);

                //Put the player in the HashMap here
                duels.put(p.getUniqueId(), ((Player) sender).getUniqueId());
            }
        }
    } else {
        sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.RED + " Player not found!");
    }
}
return true;
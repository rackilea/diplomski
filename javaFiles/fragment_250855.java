if(commandLabel.equalsIgnoreCase("gmspec")){
    if(args.length == 0 && sender instanceof Player){//check if the sender is a Player
        Player p = (Player) sender; 

        p.setGameMode(GameMode.SPECTATOR);
        p.sendMessage(ChatColor.GREEN + "Your own gamemode has been changed!");

        return true;
    }
    else{
        Player target = Bukkit.getServer().getPlayer(args[0]);

        //the rest of the code
    }
}
@Override
public boolean onCommand(CommandSender sender, Command cmd, String cl, String[] args) {
    //Check if your command was executed
    if(cmd.getName().equalsIgnorecase("yourCommand")){
        //Check if the executor of the command is a player and not a commandblock or console
        if(sender instanceof Player){

            Player player = (Player) sender;

            //Add the player's unique ID to the set
            players.add(player.getUniqueId());
        } 
    }
}
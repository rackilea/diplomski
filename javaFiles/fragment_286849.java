public void onEnable() {
    getLogger().info("Plugin Enabled!");
} //HERE ADD THE MISSING BRACE

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("Plugin")) { // If the player typed /plugin then do the following...
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Gives player item
            return true;
        } else {
            sender.sendMessage("You must be a player!");
            return false;
        }
    } else {
        return false; //HERE YOU NEED TO RETURN FROM THE ELSE TOO
    }
}
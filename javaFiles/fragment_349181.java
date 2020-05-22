public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

  if(cmd.getName().equalsIgnoreCase("heal"){
    if(sender instanceof Player){
      Player player = (Player) sender;
      if(args.length > 0){
        Player target = Bukkit.getServer().getPlayer(args[0]);
        target.setHealth(20.0);
        player.sendMessage("You have healed " + args[0]);
      }
      else{
        player.setHealth(20.0);
        player.sendMessage("You have been healed");
      }
    }
    else{
      if(args.length > 0){
        Player target = Bukkit.getServer().getPlayer(args[0]);
        target.setHealth(20.0);
        sender.sendMessage("You have healed " + args[0]);
      }
      else{
        sender.sendMessage("Correct usage: /heal <player>");
      }
    }
  }
  return true;
}
Game game;
for (int i = 0; i < Main.games.size(); i++){
    game = Main.games.get(i);
    if (game.getName().equalsIgnoreCase(args[0]) == false){
        // Do not return here. Instead, continue to check the rest of the list
        continue;
    }else{
        //Tells that a game already exists with that name.
        player.sendMessage(ChatColor.RED + "Can not create game with the name of " + args[0]);
        return true;
    }
}
// We have reached the end of the loop so we now know that none of the 
// games in the list match. Now we can return.
Main.games.add(new Game(args[0]));
player.sendMessage(ChatColor.GREEN + "Game Created. To join Type " + ChatColor.ITALIC + "/join " + args[0]);
//debug
player.sendMessage(Main.games.size() + "");
return true;
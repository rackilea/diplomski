@EventHandler
public void onInteract(PlayerInteractEvent event){
    //Check if the player right clicked.
    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
        //Check if the Set contains this player
        if(players.contains(event.getPlayer().getUniqueId()){
            //Check if the player had an item in their hand
            if(event.getPlayer().getItemInHand().getType() == Material.BOOK){
                //Remove player from the set so they have to execute the command again before right clicking the book again
                players.remove(event.getPlayer().getUniqueId());
                //Here you can do whatever you want to do when the player executed the command and right clicks a book.
            }
        }
    }
}
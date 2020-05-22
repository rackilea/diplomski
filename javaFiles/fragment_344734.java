@EventHandler(priority=EventPriority.HIGH)
public void onPlayerUse (PlayerInteractEvent evnt) {
    if(evnt.getAction().equals(Action.LEFT_CLICK_BLOCK){//make sure that they are infact hitting a block
        if(evt.getItem() == new ItemStack(Material.DIAMOND_HOE)){ //make sure they are using a diamond hoe
            Block block = evnt.getClickedBlock();
            //ItemStack item = evnt.getItem();
            //we don't need the above line any more
            Player player = evnt.getPlayer();

            World world = block.getWorld();
            ItemMeta itemmeta = item.getItemMeta();
         }
    }
}
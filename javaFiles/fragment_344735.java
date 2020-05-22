@EventHandler(priority=EventPriority.HIGH)
    public void onPlayerUse (PlayerInteractEvent evnt) {
        if(evnt.getAction().equals(Action.LEFT_CLICK_BLOCK)){//make sure that they are infact hitting a block
            if(evnt.getItem() == new ItemStack(Material.DIAMOND_HOE)){ //make sure they are using a diamond hoe
               if(evnt.getItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Bedrock Breaker")){ //make sure the name of the diamond hoe is "Bedrock Breaker" in DARK_AQUA

                Block block = evnt.getClickedBlock();
                World world = block.getWorld();
                Player player = evnt.getPlayer();
                if(block.getType() == Material.BEDROCK){ //make sure the block clicked is bedrock

                    BlockBreakEvent breakEvent = new BlockBreakEvent(block, player);
                    Bukkit.getServer().getPluginManager().callEvent(breakEvent);
                    ItemStack drop = new ItemStack(block.getType());
                    drop.setAmount(1);
                    drop.setType(Material.BEDROCK);
                    block.setType(Material.AIR);

                    world.dropItemNaturally(block.getLocation(), drop);
                    player.sendMessage("Bedrock Broken!");
                }
            }
        }
    }
    }
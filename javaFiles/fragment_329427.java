private long lastTime = System.currentTimeMillis();
@EventHandler
public void on(PlayerMoveEvent e) {
    if (lastTime < System.currentTimeMillis() - 12000) {
        Player p = e.getPlayer();

        if(p.getLocation().getBlock().getType() == Material.STONE_PLATE) {
            if(p.getLocation().subtract(0D, 1D, 0D).getBlock().getType() == Material.STAINED_CLAY) {
                Block block = p.getLocation().getBlock();

                Random ran = new Random();
                int auswahl = ran.nextInt(2);
                int zahl = ran.nextInt(main.Drops.size());

                ItemStack itemstack = main.Drops.get(zahl);
                block.getWorld().dropItemNaturally(p.getLocation(), itemstack);
            }
        }
        lastTime = System.currentTimeMillis();
    }
}
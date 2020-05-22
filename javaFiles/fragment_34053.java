public static Map<UUID, Boolean> ended = new HashMap<UUID, Boolean>();

@EventHandler
public void onMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    if (plugin.getPlayerEvent(player).equals("spleef")) {
        if (plugin.getInfo().eventstarted) {
            Material b = player.getLocation().getBlock().getType();
            if (b.equals(Material.STATIONARY_WATER) || b.equals(Material.WATER) || event.getPlayer().getLocation().getY() <= 0) {
                boolean end = false;
                if(ended.containsKey(player.getUniqueId()){
                    end = ended.get(player.getUniqueId();
                }
                //else{} we don't want to do anything if ended does not contain the player's UUID!
                if (!lul.contains(player.getName()) && !end){
                    ended.put(player.getUniqueId(), true);
                    lul.add(player.getName());
                    plugin.getMethods().basicLose(player);
                }
            }
        }
    }
}
public class MyPlugin extends JavaPlugin implements Listener {

    private HashMap<String, Integer> lastY = new HashMap<>(); //Stores the last y location for an arbitrary number of users. The map key (String) is the user's name and the value (Integer) is the user's last Y coord

    @Override
    public void onEnable(){
        //Start the timer asynchronously because it doesn't need to run on the main thread and the time will also be more accurate
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {

            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) { //Loop through all the players on the server
                    int y = player.getLocation().getBlockX();
                    player.sendMessage("Increase = " + (y - lastY.getOrDefault(player.getName(), 0))); //Display the increase in height using the stored value or 0 if none exists
                    lastY.put(player.getName(), y); //Replace their previous y coordinate with the new one
                }
            }

        }, 0, 20L);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        lastY.remove(e.getPlayer().getName()); //Remove stored data for player
    }

}
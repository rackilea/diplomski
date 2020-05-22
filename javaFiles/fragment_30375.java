private Location spawnPlayer(Player p) {
    int r = new Random().nextInt(ServerManager.getInstance().getServer(p).getSpawns().size());
    final Spawn s = ServerManager.getInstance().getServer(p).getSpawns().get(r);

    if(s.hasPlayer()){
        long timeToWait = 20L;//set the time to wait to 20 ticks (1 second)
        Bukkit.getServer().getScheduler().runTaskLater(Arsenal.p, new Runnable(){
            public void run(){
                spawnPlayer(p);
            }
         },timeToWait);
    }
    else{
        s.setPlayer(p);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Arsenal.p, new Runnable() {
            public void run() {
                spawnClear--;

                if (spawnClear == 0) {
                    s.setPlayer(null);
                }
            }
        }, 0L, 20L);
    }
    return s.getLocation();
}
if(s.hasPlayer()){
    long timeToWait = 20L;//set the time to wait to 20 ticks (1 second)
    Bukkit.getServer().getScheduler().runTaskLater(Arsenal.p, new Runnable(){
        public void run(){
            spawnPlayer(p);
        }
    },timeToWait);
}
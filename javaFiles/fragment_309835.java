Bukkit.getScheduler().scheduleSyncRepeatingTask(MyPlugin.getPlugin(), new Runnable() {

    @Override
    public void run() {
        currentTimeInSeconds--;

        switch(remainingTimeInSeconds) {
           case 60:
           case 30:
           case 15:
           case 10:
           case 5:
           case 3:
           case 2:
           case 1:
           //Send message remainingTimeInSeconds seconds left until drops are cleared!
           break;

           case 0:
           clearAllDrops();
           remainingTimeInSeconds = 300; //Reset your timer
           break;             
        }    

    }
}, 20L, 0);
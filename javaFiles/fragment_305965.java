new BukkitRunnable() {
    @Override
    public void run() {
        //Code you need running
        this.cancel();    //Cancelling
    }
}.runTaskTimer(pluginInstance, delayTime, repeatingTime);



 new BukkitRunnable() {
    @Override
    public void run() {
        //Code you need running
        this.cancel();    //Cancelling
    }
}.runTaskLater(pluginInstance, delayTime);
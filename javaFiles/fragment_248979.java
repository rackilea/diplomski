public void startWatcherService() {
    startService(new Intent (this,WatcherService.class));       
}

public void stopWatcherService() {
    sendBroadcast (new Intent(WatcherService.STOP_WATCHER_SERVICE));        
}
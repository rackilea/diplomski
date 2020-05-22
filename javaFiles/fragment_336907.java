Runnable r = new Runnable() {
    public void run() {
        synchronized (msg) { //only any use if readers are alse sync-ed
            msg.setGpsLocation(findGpsLocation(msg)); 
        }
    }
}
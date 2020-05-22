Runnable r = new Runnable() {
    public void run() {
        GpsLocation  loc = findGpsLocation(msg);
        msg.setGpsLocation(loc); //the setter is synchronized
    }
}
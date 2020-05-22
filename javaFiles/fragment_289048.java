public class Time extends Thread {
    //Thread t; // Not needed
    public int hour;
    public int minute;
    public int second;
    Calendar calendar;
    Main main; // Don't instantiate

    // Pass in the main object
    Time(Main main) {
        this.main = main;
    }

    public void run() {
        for (; ; ) {
            try {
                getTime();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    // This is not needed, Time class has its own start() method, which will call its run() method.
    //public void start() {
    //    t = new Thread(this);
    //    t.start();
    //}

    public void getTime() {
        calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        System.out.println(hour + ":" + minute + ":" + second);
        main.updateTime(hour, minute, second); // Update main
    }
}
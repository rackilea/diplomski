// Create queue, and task for adding values to queue
final ConcurrentLinkedQueue<Date[]> wait_list = new ConcurrentLinkedQueue<Date[]>();
TimerTask task = new TimerTask() {
    @Override public void run() {
        Date actualTime = new Date();
        Date scheduledTime = new Date(this.scheduledExecutionTime());
        wait_list.add(new Date[] { scheduledTime, actualTime });
        if (actualTime.getTime() % 3 == 0) // Add two elements about 33% of the time
            wait_list.add(new Date[] { scheduledTime, actualTime });
    }
};

// Run task every 0.1 second
Timer timer = new Timer();
timer.scheduleAtFixedRate(task, 100, 100);

// Process next 10 values, printing "Waiting" whenever queue goes empty
SimpleDateFormat fmt = new SimpleDateFormat("mm:ss.SSS");
boolean waiting = false;
int countDown = 10;
while (countDown > 0) {
    if (wait_list.isEmpty()) {
        if (! waiting) {
            System.out.println("Waiting");
            waiting = true;
        }
    } else {
        Date[] date = wait_list.remove();
        System.out.println("Good: scheduled=" + fmt.format(date[0]) + ", actual=" + fmt.format(date[1]));
        waiting = false;
        countDown--;
    }
}

// Stop timer
timer.cancel();
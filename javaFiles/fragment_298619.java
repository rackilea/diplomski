public class TaskTest {
    public static scheduleTask(int interval) {
        GregorianCalendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int hourScheduled = hour;

        // if we are past the scheduled time then schedule for the next hour
        if (minute > interval) {
            ++hourScheduled;
        }
        cal.set(year, month, date, hourScheduled, interval);
        long initialDelay = cal.getTimeInMillis() - System.currentTimeMillis();
        if (initialDelay < 0) {
            initialDelay = 0L;
        }
        // schedule each job for once per hour
        int period = 60*60*1000;

        Timer timer = new Timer();
        SomeTask someTask = new SomeTask();
        timer.scheduleAtFixedRate(someTask, initialDelay, period);
    }

    public static void main(String[] args) {
        // schedule for the 15th, 25th and 45th min of time every hour
        scheduleTask(15);
        scheduleTask(25);
        scheduleTask(45);
    }
}

public class SomeTask extends TimerTask {
    @Override
    public void run() {
        // do something
    }
}
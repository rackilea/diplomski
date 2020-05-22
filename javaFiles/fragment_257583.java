public class App {
    public static void main(String[] args) {
        final Timer timer = new Timer();
        Timer stopTaskTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Output");
            }
        };
        TimerTask stopTask = new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
            }
        };

        //schedule your repetitive task
        timer.scheduleAtFixedRate(task, 0, 1000);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse("2015-06-09 14:06:30");
            //schedule when to stop it
            stopTaskTimer.schedule(stopTask, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}